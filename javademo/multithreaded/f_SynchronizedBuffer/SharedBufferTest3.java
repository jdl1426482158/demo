package f_SynchronizedBuffer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import z_common.*;

public class SharedBufferTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService application = Executors.newCachedThreadPool();
		
		Buffer sharedLocation = new SynchronizedBuffer();
		
		System.out.printf("%-40s%s\t\t%s\n%-40s%s\n\n","Operation",
				"Buffer","Occupied","---------","------\t\t--------");
		
		application.execute(new Producer( sharedLocation ) );
		application.execute(new Consumer( sharedLocation ) );
		
		application.shutdown();
	}

}
