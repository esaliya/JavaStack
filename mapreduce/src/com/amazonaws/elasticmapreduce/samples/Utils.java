package com.amazonaws.elasticmapreduce.samples;

import java.util.Date;


public class Utils {
	
	public static String formatString(String val){
		String ret = val.replace("-", "_");
		ret = ret.replace(" ", "_");
		return ret.replace(":", "_");
	}
	
	public static void main(String[] args) {
		System.out.println(formatString("Class-job-flowSun Mar 07 10:58:14 EST 2010"));
        System.out.println(new Date().toString());
	}

}
