package multithread.z_common;

public interface Buffer {
	public void set(int value )throws InterruptedException;
	
	public int get() throws InterruptedException;
}