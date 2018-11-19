package multithread.h_SynchronizedBuffer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import multithread.z_common.*;

public class SynchronizedBuffer implements Buffer{
	
	private final Lock accessLock = new ReentrantLock();
	
	private final Condition canWrite = accessLock.newCondition();
	private final Condition canRead = accessLock.newCondition();
	
	private int buffer = -1;
	private boolean occupied = false;
	
	public void set(int value ) throws InterruptedException
	{
		accessLock.lock();
		
		try
		{
			while (occupied)
			{
				System.out.println("Producer tries to write.");
				displayState("Buffer full. Producer waits.");
				canWrite.await();
			}
			
			buffer = value;
			
			occupied = true;
			 
			displayState("Producer writes "+buffer);
			
			canRead.signal();
		}
		finally
		{
			accessLock.unlock();
		}
	}
	
	public int get()throws InterruptedException
	{
		int readValue = 0;
		accessLock.lock();
		try
		{
			while (!occupied)
			{
				System.out.println("Consumer tries to read.");
				displayState("Buffer empty. Consumer waits.");
				canRead.await();
			}
			
			occupied = false;
			
			readValue = buffer;
			displayState("Consumer reads "+readValue);
			
			canWrite.signal();
		}
		finally
		{
			accessLock.unlock();
		}
		
		return readValue;
	}
	
	public void displayState(String operation)
	{
		System.out.printf("%-40s%d\t\t%b\n\n", operation,buffer,
				occupied );
	}
}
