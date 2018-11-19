package multithread.c_producer;

import java.util.Random;

public class Producers implements Runnable {
	
	private final static Random generator = new Random();
	private final Buffer sharedLocation;

	public Producers(Buffer shared) {
		sharedLocation = shared;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int sum = 0;

		for (int count = 1; count <= 10; count++) {
			try {
				Thread.sleep(generator.nextInt(3000));
				sharedLocation.set(count);
				sum += count;
				System.out.printf( "\t%2d\n", sum);              //////当其他包用到是去掉这行？
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
		}
		System.out.println(
				"Producer done producing\nTermination Producer");
	}
}
