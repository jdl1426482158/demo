package basic.thread;

public class ThreadRunA {
	private static class RunnableA implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				try {
					Thread.sleep(1000);
					System.out.println("猜猜我是谁");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					break;
				}
			}
		}
	}
	
	private static class ThreadA extends Thread {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				try {
					Thread.sleep(1000);
					System.out.println("niconiconi");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					break;
				}
			}
		}
	}
	
	public static void main(String argv[])
	{
		new Thread(new RunnableA()).start();
		new ThreadA().start();
	}
}
