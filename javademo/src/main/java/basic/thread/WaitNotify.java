package basic.thread;

/*
 * �߳�x��a.waitʹ��ǰ������a������
 * Ȼ���ͷ�a��������a�����ĵȴ��أ�
 * ֮������������߳������ڻ��a���������a.notify()�������̣߳�
 * ʹ��������صȴ���ȡ���پ�����
 * 
 * ���ã�
 * ����������ͬ�����Ŀ�ֻ��һǰһ��ִ�У�
 * ����wait��notify���൱�ڣ���notify�����ͬ����Ƕ�뵽waitλ�ô�ִ�С�
 * 
 * ReentrantLock����con = newCondition����ȡ��������con.await��con.signal��wait��notify���Ƶ�����
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
