package g_BoundedBuffers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import z_common.*;

public class CircularBufferTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			ExecutorService application = Executors.newCachedThreadPool();
			
			CircularBuffer sharedLocation = new CircularBuffer();
			sharedLocation.displayState("Initial State");
			
			application.execute(new Producer(sharedLocation));
			application.execute(new Consumer(sharedLocation));
			
			application.shutdown();
		
	}

}
