package com.jspiders.multithreading.main;
import com.jspiders.multithreading.thread.MyThread2;

public class ThreadMain2 {
	public static void main(String[] args) {
		MyThread2 myThread2 = new MyThread2();
		Thread thread = new Thread(myThread2); 
		thread.start();
	}
}
//MyThread2 implements runnable interface which does not contains run method
//so here we create object of thread class(which contains run method) and pass myThread2 as argument
//and call start method as thread.start() instead of myThread2.start()