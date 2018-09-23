package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadRunB {
	
	private static class ThreadA extends Thread {
		
		private static String s;
		
		public ThreadA() {
			s  = "niconiconi";
		}
		
		public ThreadA(String m) {
			s = m;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				try {
					Thread.sleep(1000);
					System.out.println(s);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService pool=Executors.newCachedThreadPool();
		ThreadA a = new ThreadA();
		ThreadA b = new ThreadA("bilibili");
		pool.execute(a);
		pool.execute(b);
		//pool.shutdown();
	}

}
