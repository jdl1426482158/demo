package thread;

public class ThreadRunC extends Thread {

	public static int a = 0;

	@Override
	public void run() {
		int k = 1000000;
		while (k > 0) {
			k--;
			a = a + 1;
			a = a - 1;
		}
		System.out.println(a);
		super.run();
	}

	public static void main(String[] args) {
		new ThreadRunC().start();
		new ThreadRunC().start();
	}

}
