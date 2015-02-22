package edu.indiana.cs.b534.clients;

import org.jets3t.service.S3Service;
import org.jets3t.service.S3ServiceException;
import org.jets3t.service.impl.rest.httpclient.RestS3Service;
import org.jets3t.service.model.S3Bucket;
import org.jets3t.service.model.S3Object;
import org.jets3t.service.security.AWSCredentials;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;

public class S3Client {
    private S3Service s3;

    public S3Client(String accessKey, String secretKey) throws S3ServiceException {
        s3 = new RestS3Service(new AWSCredentials(accessKey, secretKey));
    }

    public void get(String aPath, String path)
            throws S3ServiceException, IOException {
        File f = new File(path);
        if (f.isDirectory()) {
            int idx = aPath.indexOf("/");
            S3Object o = s3.getObject(aPath.substring(0, idx), aPath.substring(idx + 1));
            InputStream in = o.getDataInputStream();
            OutputStream out = new FileOutputStream(path + aPath.substring(aPath.lastIndexOf("/")));
            byte[] bytes = new byte[4096];//4k chunks
            int len;
            while ((len = in.read(bytes)) != -1) {
                out.write(bytes, 0, len);
            }
            in.close();
            out.close();
        } else {
            System.out.println("Directory does not exist\n" + path);
        }
    }

    public void put(String path, String aPath)
            throws IOException, NoSuchAlgorithmException, S3ServiceException {

        File f = new File(path);
        if (f.isFile()) {
            S3Object o = new S3Object(f);
            o.setKey(aPath.substring(aPath.indexOf("/") + 1) + "/" + f.getName());
            s3.putObject(aPath.substring(0, aPath.indexOf("/")), o);
        }
    }

    public void als() throws S3ServiceException {
        S3Bucket[] buckets = s3.listAllBuckets();
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy  hh:mm a    ");
        System.out.println("Created Time            Type     Name");
        for (S3Bucket b : buckets) {
            System.out.print(fmt.format(b.getCreationDate()));
            System.out.print("<DIR>    ");
            System.out.println(b.getName());
        }
    }
}
