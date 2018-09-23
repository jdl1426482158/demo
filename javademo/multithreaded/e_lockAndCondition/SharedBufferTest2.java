package e_lockAndCondition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import z_common.*;

public abstract class SharedBufferTest2 {
	public static void main(String args[]) {
		ExecutorService application = Executors.newCachedThreadPool();

		Buffer sharedLocation = new SynchronizedBuffer();
		
		System.out.printf("%-40s%s\t\t%s\n%-40s%s\n\n", "Operator", "Buffer",
				"Occpuied", "---------", "------\t\t--------");
		application.execute(new Producer(sharedLocation));
		application.execute(new Consumer(sharedLocation));
		
		application.shutdown();/////////////////////////////
	}
}
