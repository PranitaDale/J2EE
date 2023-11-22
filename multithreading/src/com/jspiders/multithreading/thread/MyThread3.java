package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resource.Resource;

public class MyThread3 extends Thread{
	private Resource resource;
	
	public MyThread3(Resource resource) {
		this.resource = resource;
	}
	@Override
	public void run() {
		resource.message();
	}
	
	
}
