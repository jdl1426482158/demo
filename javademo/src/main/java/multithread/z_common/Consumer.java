package multithread.z_common;

import java.util.Random;

public class Consumer implements Runnable{
	private final static Random generator = new Random();
	private final Buffer sharedLocation;
	
	public Consumer(Buffer shared)
	{
		sharedLocation = shared;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int sum = 0;
		
		for(int count = 1; count <=10; count++)
		{
			try
			{
				Thread.sleep(generator.nextInt(3000));
				sum +=sharedLocation.get();
			}
			catch(InterruptedException exception)
			{
				exception.printStackTrace();
			}
		}
		System.out.printf("\n%s %d\n%s\n","Counsumer read "
				+ "values totaling",sum,"Terminating Consumer");
	}
}
