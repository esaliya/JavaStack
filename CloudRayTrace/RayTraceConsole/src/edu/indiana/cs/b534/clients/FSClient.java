package edu.indiana.cs.b534.clients;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FSClient {
    private String workingPath = ".";

    public void pwd() {
        System.out.println(workingPath);
    }

    /**
     * Change the working directory. To change to a different drive in
     * Windows the path should be X:\ where X is the drive letter. This
     * is not a perfect cd similar to what is there in Windows or Linux
     * terminal/shell
     * @param path the path to change directory to
     * @throws java.io.IOException if an I/O error occurs
     */
    public void cd(String path) throws IOException {
        if (path.startsWith(File.separator) || (path.length()>1 && path.charAt(1) == ':')) {
            File target = new File(path);
            if (target.isDirectory()) {
                workingPath = target.getCanonicalPath();
            } else {
                System.out.println("Invalid directory path");
            }
        } else {
            File target = new File(workingPath + File.separator + path);
            if (target.isDirectory()) {
                workingPath = target.getCanonicalPath();
            } else {
                System.out.println("Invalid directory path");
            }
        }
    }

    public void ls() {
        File wd = new File(workingPath);
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
