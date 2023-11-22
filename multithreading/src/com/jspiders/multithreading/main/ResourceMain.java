package com.jspiders.multithreading.main;

import com.jspiders.multithreading.resource.Resource;
import com.jspiders.multithreading.thread.MyThread3;
import com.jspiders.multithreading.thread.MyThread4;

public class ResourceMain {

	public static void main(String[] args) {
		Resource resource = new Resource();
		MyThread3 myThread3 = new MyThread3(resource);
		myThread3.setName("MyThread3");
		MyThread4 myThread4 = new MyThread4(resource);
		myThread4.setName("MyThread4");
		
		
		
		myThread3.start();
		myThread4.start();
	}
}
