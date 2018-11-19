package basic.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexSync {
	private static int a = 0;
	private static int b = 0;
	private final static Object lock = "hello";
	private final static Lock lock1 = new ReentrantLock();
	public static void SyncTest_No(String name){
		a = a+1;
		b = b+1;
		System.out.println(String.format("%s: a = %d; b = %d",name, a,b));
	}
	
	public synchronized static void SyncTest_Sync1(String name){
		a = a+1;
		b = b+1;
		System.out.println(String.format("%s: a = %d; b = %d",name, a,b));
	}
	
	public static void SyncTest_Sync2(String name){
		synchronized(lock) {
		a = a+1;
		b = b+1;
		System.out.println(String.format("%s: a = %d; b = %d",name, a,b));
		} 
	}
	
	public synchronized static void SyncTest_Sync3(String name){
		a = a+1;
		b = b+1;
		System.out.println(String.format("%s: a = %d; b = %d",name, a,b));
	}
	
	public synchronized static void SyncTest_ReentrantLoc(String name){
		lock1.lock();
		a = a+1;
		b = b+1;
		System.out.println(String.format("%s: a = %d; b = %d",name, a,b));
		lock1.unlock();
	}

}
