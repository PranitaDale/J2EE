package com.jspiders.filehandling.operations;

import java.io.File;
import java.io.IOException;

public class CreateNewFileDemo3 {
	public static void main(String[] args) {
		File file = new File("D:/WEWM7/Demo.txt");
		
		if(file.exists()) {
			System.out.println("File already exist.");
		}
		else {
			try {
				file.createNewFile();
				System.out.println("File created Successfully...");
				
			} catch (IOException e) {
				System.out.println("File does not created.");
				e.printStackTrace();
			}
		}
		
	}
}
