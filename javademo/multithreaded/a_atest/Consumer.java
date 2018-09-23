package a_atest;

import java.util.Random;

public class Consumer implements Runnable{
	
	private final Buffer sharedLocation;
	private final Random generator = new Random();
	public Consumer(Buffer shared)
	{
		sharedLocation = shared;
	}
	
	public void run()
	{
		int sum = 0;
		
		for(int i = 1; i <= 10; i++)
		{
			try {
				Thread.sleep(generator.nextInt(3000));
				sum += sharedLocation.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Consumer ended with " + sum);
	}

}
