package a_atest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MySharedBuffer implements Buffer{

	private int buffer=0;
	private final Lock accessLock;
	private final Condition canWrite;
	private final Condition canRead;
	private boolean occupied = false;      ////////false 
	public MySharedBuffer()
	{
		accessLock = new ReentrantLock();
		canWrite = accessLock.newCondition();
		canRead = accessLock.newCondition();
	}
	
	public void set(int value) throws InterruptedException {
		// TODO Auto-generated method stub
		accessLock.lock();
		
		while(occupied)
		{
			System.out.printf("Producer tries to write\n");
			displayMessage("Buffer has been full. Producer waits");
			canWrite.await();
			//isRun = true;
		}
		buffer = value;
		
		System.out.printf("Producer writes %d   %b\n",buffer,occupied);
		
		occupied = true;
		canRead.signal();
		accessLock.unlock();
	}

	@Override
	public int get() throws InterruptedException {
		// TODO Auto-generated method stub
		int readValue = 0;
		accessLock.lock();
		
		while(!occupied)
		{
			System.out.printf("Consumer tries to read\n");
			displayMessage("Buffer has been null. Consumer waits");
			canRead.await();
		}
		
		readValue = buffer;
		
		System.out.printf("Consumer reads %d   %b\n",buffer,occupied);
		
		occupied = false;
		canWrite.signal();
		accessLock.unlock();
		return readValue;
	}
	
	private void displayMessage(String message)
	{
		System.out.printf("%-40s\t%d%-20b\n", message,buffer,occupied);
	}
	
}
