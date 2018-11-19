package basic.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author zhangliang
 *
 *         2016��4��8�� ����5:48:54
 */
public class ConTest {

	final Lock lock = new ReentrantLock();
	final Condition condition = lock.newCondition();

	public static void main(String[] args) {
		ConTest test = new ConTest();
		Producer producer = test.new Producer("Producer");
		Consumer consumer = test.new Consumer("Consumer");

		consumer.start();
		producer.start();
	}

	class Consumer extends Thread {
		public Consumer(String name) {
			super(name);
		}

		@Override
		public void run() {
			consume();
		}

		private void consume() {
			try {
				lock.lock();
				System.out.println("���ڵ�һ�����ź�" + Thread.currentThread().getName());
				condition.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				System.out.println("�õ�һ���ź�" + Thread.currentThread().getName());
				lock.unlock();
			}
		}
	}

	class Producer extends Thread {

		public Producer(String name) {
			super(name);
		}

		@Override
		public void run() {
			produce();
		}

		private void produce() {
			try {
				lock.lock();
				System.out.println("���õ���" + Thread.currentThread().getName());
				condition.signalAll();
				System.out.println("�ҷ�����һ���źţ�" + Thread.currentThread().getName());
			} finally {
				lock.unlock();
			}
		}
	}

}
