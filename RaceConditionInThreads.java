package com.race;

public class RaceConditionForThreads {
	  int count=0;
	public static void main (String[] args) throws InterruptedException {
		RaceConditionForThreads rc=new RaceConditionForThreads();
		Runnable run1=()->{
			for(int i=0;i<5;i++) {
				rc.counter();

			}
		};
		Runnable run2=()->{
			for(int i=0;i<5;i++) {
				rc.counter();
			}
		};
		Thread thread1=new Thread(run1);
		Thread thread2=new Thread(run2);
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		System.out.println(rc.count);
	}
	public synchronized void counter() {
		count++;
		
	}
}
