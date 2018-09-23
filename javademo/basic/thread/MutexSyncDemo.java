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
				//Sync.SyncTest_No(name); //�����a!=b�Ľ��
				MutexSync.SyncTest_ReentrantLoc(name);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}

		}
	}
	
/*	�����ͬ��ע�͵���main����һ����Ե�
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
					// Sync.SyncTest_No(name); //�����a!=�Ľ��
					Sync.SyncTest_Sync3(name);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					break;
				}

			}
		}
	}
//	Sync.SyncTest_Sync1(name)��Sync.SyncTest_Sync3(name)������ͬ����
//	Sync.SyncTest_Sync1(name)��Sync.SyncTest_Sync2(name)�Ͳ���ͬ����
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
