package com.jspiders.serializationdeserialization.serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.jspiders.serializationdeserialization.serialization.object.copy.User;


public class Serial {
	
	public static void main(String[] args) throws IOException {
		File file = new File("File.txt");
		if(file.exists()) {
			System.out.println("File Already Exist");
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(new User(1, "Ramesh", "ramesh@gmail.com", "Ramesh@123"));
			System.out.println("Object written to the file.");
			objectOutputStream.close();
		}
		else {
			file.createNewFile();
			System.out.println("File is created.");
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(new User(1,"Ramesh", "ramesh@gmail.com", "Ramesh@123" ));
			System.out.println("Object written to the file.");
			objectOutputStream.close();
			fileOutputStream.close();

		}
	}

}
