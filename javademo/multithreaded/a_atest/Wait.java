package a_atest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Wait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService application = Executors.newCachedThreadPool();
		
		MySharedBuffer sharedLocation = new MySharedBuffer();
		
		application.execute(new Producer(sharedLocation));
		application.execute(new Consumer(sharedLocation));
		
		application.shutdown();
		
	}

}
