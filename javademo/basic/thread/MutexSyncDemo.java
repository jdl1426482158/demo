package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MutexSyncDemo implements Runnable {
	private String name;

	public MutexSyncDemo(String s) {
		this.name = s;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
				//Sync.SyncTest_No(name); //会出现a!=b的结果
				MutexSync.SyncTest_ReentrantLoc(name);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}

		}
	}
	
/*	这个是同被注释掉的main函数一起测试的
 private static class ThreadDemoC_Copy implements Runnable {
		private String name;

		public ThreadDemoC_Copy(String s) {
			this.name = s;
		}

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(100);
					// Sync.SyncTest_No(name); //会出现a!=的结果
					Sync.SyncTest_Sync3(name);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					break;
				}

			}
		}
	}
//	Sync.SyncTest_Sync1(name)和Sync.SyncTest_Sync3(name)还是能同步的
//	Sync.SyncTest_Sync1(name)和Sync.SyncTest_Sync2(name)就不能同步的
	public static void main(String argv[]) {
		ThreadDemoC a = new ThreadDemoC("A");
		ThreadDemoC_Copy c = new ThreadDemoC_Copy("C");
		ExecutorService pool = Executors.newCachedThreadPool();
		pool.execute(a);
		pool.execute(c);
	}
*/

	public static void main(String argv[]) {
		MutexSyncDemo a = new MutexSyncDemo("A");
		MutexSyncDemo b = new MutexSyncDemo("B");
		ExecutorService pool = Executors.newCachedThreadPool();
		pool.execute(a);
		pool.execute(b);
	}
	
}
