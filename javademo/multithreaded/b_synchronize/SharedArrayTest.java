package b_synchronize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleArray sharedSimpleArray = new SimpleArray(6);
		
		ArrayWriter writer1 = new ArrayWriter(1,sharedSimpleArray);
		ArrayWriter writer2 = new ArrayWriter(11,sharedSimpleArray);
		
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(writer1);
		executor.execute(writer2);
		
		executor.shutdown();
		
		try
		{
			boolean tasksEnded = executor.awaitTermination(
					2, TimeUnit.SECONDS);
			if(tasksEnded)
				System.out.println(sharedSimpleArray);
			else
				System.out.println(
						"Timed out while waiting for tasks to finish.");
		}
		catch(InterruptedException ex)
		{
			System.out.println(
					"Interrupted while waiting for tasks to finish.");
		}	
	}
}
