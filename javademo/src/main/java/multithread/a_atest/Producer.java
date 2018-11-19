package multithread.a_atest;

import java.util.Random;

public class Producer implements Runnable{
	
	private final Buffer sharedLocation;
	private final Random generator = new Random();
	
	public Producer(Buffer shared)
	{
		sharedLocation = shared;
	}
	
	public void run()
	{
		for(int i = 1; i <= 10; i++)
		{
			try {
				Thread.sleep(generator.nextInt(3000));
				sharedLocation.set(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Producer ended");
	}

}
