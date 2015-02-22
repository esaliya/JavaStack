package edu.indiana.b34.s3client.simple;


import org.jets3t.service.S3Service;
import org.jets3t.service.S3ServiceException;
import org.jets3t.service.impl.rest.httpclient.RestS3Service;
import org.jets3t.service.model.S3Bucket;
import org.jets3t.service.model.S3Object;
import org.jets3t.service.security.AWSCredentials;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class S3Console {
    static final String USAGE= "\nUsage: S3Console credentialsFile";
    static String wdpath;
    static String awdpath = "";

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println(USAGE);
            System.exit(1);
        }
        wdpath = new File(".").getAbsoluteFile().getParent();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String accessKey, secretKey;
            accessKey = reader.readLine();
            secretKey = reader.readLine();
            createS3Console(accessKey, secretKey);
        } catch (FileNotFoundException e) {
            System.out.println("\nError - Unable to find file:\n" + e.getMessage());
        } catch (IOException e) {
            System.out.println("\nError - Unable to access I/O:\n" + e.getMessage());
        } catch (S3ServiceException e) {
            System.out.println("\nError - Unable to access AWS:\n" + e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("\nError - Unable to access algorithm:\n" + e.getMessage());
        }

    }

    public static void createS3Console(String accessKey, String secretKey)
            throws S3ServiceException, IOException, NoSuchAlgorithmException {
         AWSCredentials awsCredentials =
                new AWSCredentials(accessKey, secretKey);
        S3Service s3Service = new RestS3Service(awsCredentials);
        String cmd;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("s3c>");
        while (!"exit".equalsIgnoreCase(cmd = reader.readLine())) {
            if (cmd.startsWith("ls")) {
                ls();
            } else if (cmd.startsWith("cd")) {
                cd(cmd.substring(cmd.indexOf(" ") + 1));
            } else if (cmd.startsWith("pwd")) {
                pwd();
            } else if (cmd.startsWith("als")) {
                als(s3Service);
            } else if (cmd.startsWith("put")) {
                String [] params = cmd.split(" ");
                put(params[1], params[2], s3Service);
            } else if (cmd.startsWith("get")) {
                String [] params = cmd.split(" ");
                get(params[1], params[2], s3Service);
            }
            System.out.print("\ns3c>");
        }
    }

    public static void get(String aPath, String path, S3Service s3Service)
            throws S3ServiceException, IOException {
        File f = new File(path);
        if (f.isDirectory()) {
            int idx =aPath.indexOf("/");
            S3Object o = s3Service.getObject(aPath.substring(0, idx), aPath.substring(idx+1));
            InputStream in = o.getDataInputStream();
            OutputStream out = new FileOutputStream(path+aPath.substring(aPath.lastIndexOf("/")));
            byte[] bytes = new byte[4096];//4k chunks
            int len;
            while ((len = in.read(bytes)) != -1) {
                out.write(bytes, 0 , len);
            }
            in.close();
            out.close();
            System.out.println("Download successful");
        }
    }

    public static void put(String path, String aPath, S3Service s3Service)
            throws IOException, NoSuchAlgorithmException, S3ServiceException {
        
        File f = new File(path);
        if (f.isFile()) {
            S3Object o = new S3Object(f);
            o.setKey(aPath.substring(aPath.indexOf("/") + 1) + "/" + f.getName());
            s3Service.putObject(aPath.substring(0, aPath.indexOf("/")), o);
            System.out.println("Upload successful");
        }
    }

    public static void als(S3Service s3Service) throws S3ServiceException {
        if ("".equals(awdpath)) {
            S3Bucket [] buckets = s3Service.listAllBuckets();
            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy  hh:mm a    ");
            System.out.println("Created Time            Type     Name");
            for (S3Bucket b : buckets) {
                System.out.print(fmt.format(b.getCreationDate()));
                System.out.print("<DIR>    ");
                System.out.println(b.getName());
            }
        } else {
            String [] parts = awdpath.split("/");
            S3Bucket b = s3Service.getBucket(parts[0]);
            if (parts.length > 1) {
                for (int i = 1; i < parts.length; i++) {
//                    b = s3Service.getObject(b, parts[i]);

                }
            }
        }
    }

    public static void pwd() {
        System.out.println(wdpath);
    }

    /**
     * Change the working directory. To change to a different drive in
     * Windows the path should be X:\ where X is the drive letter. This
     * is not a perfect cd similar to what is there in Windows or Linux
     * terminal/shell
     * @param path
     */
    public static void cd(String path) throws IOException {
        if (path.startsWith(File.separator) || (path.length()>1 && path.charAt(1) == ':')) {
            File target = new File(path);
            if (target.isDirectory()) {
                wdpath = target.getCanonicalPath();
            } else {
                System.out.println("Invalid directory path");
            }
        } else {
            File target = new File(wdpath + File.separator + path);
            if (target.isDirectory()) {
                wdpath = target.getCanonicalPath();
            } else {
                System.out.println("Invalid directory path");
            }
        }
    }

    public static void ls() {
        File wd = new File(wdpath);
        File [] files = wd.listFiles();
        Date date;
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy  hh:mm a    ");
        System.out.println("Modified Time           Type     Name");
        for (File f : files) {
            date = new Date(f.lastModified());
            System.out.print(fmt.format(date));
            System.out.print(f.isDirectory()? "<DIR>    " : "<FILE>   ");
            System.out.println(f.getName());
            
        }
    }
}
