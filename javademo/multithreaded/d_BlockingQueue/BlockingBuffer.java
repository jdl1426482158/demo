package d_BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

import z_common.Buffer;

public class BlockingBuffer implements Buffer 
{
	private final ArrayBlockingQueue<Integer> buffer;
	
	public BlockingBuffer()
	{
		buffer = new ArrayBlockingQueue<Integer>(1);
	}
	
	public void set( int value ) throws InterruptedException
	{
		buffer.put( value );
		///////////////////////buffer.put(value);
		System.out.printf("%s%2d\t%s%d\n", "Producer Writes ", value,
				"Buffer cells occupied: ", buffer.size());
	}
	
	public int get() throws InterruptedException
	{
		int readValue = buffer.take();
		System.out.printf("%s %2d\t%s%d\n", "Consumer reads ",
				readValue, "Buffer cells occupied: ", buffer.size() );
		
		return readValue;
	}
}
