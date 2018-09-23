package c_producer;

import java.util.Random;

public class Producer implements Runnable {
	
	private final static Random generator = new Random();
	private final Buffer sharedLocation;

	public Producer(Buffer shared) {
		sharedLocation = shared;
	}

	@Override
	public void run() {
		for (int count = 1; count <= 10; count++) {
			try {
				Thread.sleep(generator.nextInt(3000));
				sharedLocation.set(count);
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
		}
		System.out.println(
				"Producer done producing\nTermination Producer");
	}
}
