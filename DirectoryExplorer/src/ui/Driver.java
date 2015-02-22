package ui;

import javax.swing.*;
import java.io.File;

public class Driver {
    public static void main(String[] args) {
//        FileTableModel ftm = new FileTableModel();
//        ftm.setFiles(File.listRoots());
//        TableTest tt = new TableTest();
        ListView lv = new ListView();
        lv.pack();
        lv.setVisible(true);
        lv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        File[] roots = File.listRoots();
//        System.out.println(roots[0].isFile());
//        System.out.println(roots[0].isDirectory());
//        String path = roots[0].getAbsolutePath();
//        System.out.println(path.substring(path.lastIndexOf(File.separator) + 1).equals(""));
//        System.out.println(path);
//        System.out.println(roots[0].length());

    }
}
