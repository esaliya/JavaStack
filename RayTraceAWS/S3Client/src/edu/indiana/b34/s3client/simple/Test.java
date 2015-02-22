package edu.indiana.b34.s3client.simple;

import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
//        String path ="/saliya/wc/wordcount/hello";
//        String [] arr = path.split("");
//        for (String s : arr) {
//            System.out.println(s);
//        }
        String s = "put c:\\";
        String pat = "upload \\w:\\\\(\\w*)";
        Pattern p = Pattern.compile(pat);
        System.out.println(p.matcher(s).matches());


    }
}
