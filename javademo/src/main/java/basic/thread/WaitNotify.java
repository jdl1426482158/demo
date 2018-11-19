package basic.thread;

/*
 * 线程x在a.wait使用前必须获得a的锁，
 * 然后释放a的锁进入a关联的等待池，
 * 之后必须再其他线程里面在获得a的锁后调用a.notify()来唤醒线程，
 * 使其进入锁池等待获取锁再竞争锁
 * 
 * 作用：
 * 本来两个用同样锁的块只能一前一后执行，
 * 用了wait和notify后相当于，把notify哪里的同步块嵌入到wait位置处执行。
 * 
 * ReentrantLock中用con = newCondition来获取重入锁，con.await和con.signal有wait和notify相似的作用
 */


public class WaitNotify {
	
	private static class Source {
		private static int a = 0;
		private static int b = 0;
		

		public static void print() {
			a = a + 1;
			b = b + 1;
			System.out.println("The value of a and b is: " + a + " ^_^ " + b + ".");
		}
	}

	private static class ThreadA extends Thread {

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1);
					Source.print();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					break;
				}

				try {
					synchronized (this) {
						Thread.sleep(3000);
						this.notify();
						Thread.sleep(3000);
						System.out.println("ThreadA");
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("threadSync");
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String argv[]) {
		ThreadA a = new ThreadA();

		synchronized (a) {
			try {
				a.start();
				a.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("end of main");
	}
}
