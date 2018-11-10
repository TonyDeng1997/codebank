package com.webbertech.leetcode.util;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CodeAnalysis {
    final static String CUR_DIR =  System.getProperty("user.dir");
    final static String JAVA_EXT = ".java";
	static List<File> javaFiles = new ArrayList<>();
	
	static void findFiles(String dir, String ext,List<File> javaFiles) {
		File directory = new File(dir);
        File[] list = directory.listFiles();
        if (list == null) return;
		for (File file : list ) {
			if (file.isDirectory() && !file.isHidden() && !file.getName().startsWith(".")&& !file.getName().endsWith("util")) {
    	    	findFiles(file.getAbsolutePath(), ext, javaFiles);
    	    } // add files to list 
    		else if (file.isFile() && !file.isHidden() && file.getName().endsWith(ext)) {
                javaFiles.add(file);    	    	
    	    }
		}
	}
	
    public static void main(String[] args) {
		/*
	       System.out.println("Working Directory = " +
	              System.getProperty("user.dir")); */
		String path = "C:\\Users\\linfeng\\Dropbox\\LeetCodePractise\\src";
		 findFiles(path, JAVA_EXT, javaFiles);
		 System.out.println(javaFiles.size());
	}
}