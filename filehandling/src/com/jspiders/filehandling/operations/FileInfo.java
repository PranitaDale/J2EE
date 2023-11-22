package com.jspiders.filehandling.operations;

import java.io.File;

public class FileInfo {

	public static void main(String[] args) {
		File file = new File("Demo.txt");
		
		if(file.exists()) {
			System.out.println("Name: "+ file.getName());
			System.out.println("Path: " + file.getAbsolutePath());
			
			if(file.canRead()) {
				System.out.println("file is readable.");
			}
			else {
				System.out.println("file is not readable.");
			}
			
			if(file.canWrite()) {
				System.out.println("file is writable.");
			}
			else {
				System.out.println("file is not writable.");
			}
			
			if(file.canExecute()) {
				System.out.println("file is executable");
			}
			else {
				System.out.println("file is not executable.");
			}
			
			System.out.println("Lenth: "+ file.length());
		}
		else {
			System.out.println("file does not exist.");
		}
		
	}
}
