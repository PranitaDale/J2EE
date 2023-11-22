package com.jspiders.filehandling.operations;

import java.io.File;
import java.io.IOException;

public class CreateNewFileDemo2 {

	public static void main(String[] args) {
		File file = new File("Demo.txt");
		
		if(file.exists()) {
			System.out.println("File already exist.");
		}
		else {
			try {
				file.createNewFile();
				System.out.println("File created successfully...");
			}catch(IOException e){
				e.printStackTrace();
				System.out.println("File is not created.");
			}
		}
	}
}
