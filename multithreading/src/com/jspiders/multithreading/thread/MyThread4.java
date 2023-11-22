package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resource.Resource;

public class MyThread4 extends Thread{
	private Resource resource;
	
	public MyThread4(Resource resource) {
		this.resource = resource;
	}
	@Override
	public void run() {
		resource.message();
	}

}
