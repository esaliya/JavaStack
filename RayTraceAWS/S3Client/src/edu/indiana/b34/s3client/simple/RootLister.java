package edu.indiana.b34.s3client.simple;

import java.io.File;

public class RootLister {
    public static void main(String[] args) {
        File [] roots = File.listRoots();
        for (int i = 0; i < roots.length; i++) {
            File root = roots[i];
            System.out.println(root.getAbsolutePath());
        }
    }
}
