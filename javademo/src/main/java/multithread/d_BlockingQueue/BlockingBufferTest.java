package multithread.d_BlockingQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import multithread.z_common.*;

public class BlockingBufferTest {
	public static void main(String[] args)
	{
		ExecutorService application = Executors.newCachedThreadPool();
		Buffer sharedLocation = new BlockingBuffer();
		
		application.execute(new Producer( sharedLocation ) );
		application.execute(new Consumer( sharedLocation ) );
		
		application.shutdown();
	}
}
