package com.jspiders.filehandling.operations;

import java.io.File;
import java.io.IOException;

public class CreateFileDemo1 {
	
	public static void main(String[] args) {
		File file = new File("Demo.txt");
		
		try {
			file.createNewFile();
			System.out.println("File Created Successfully...");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
