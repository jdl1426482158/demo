package io.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class ServerDatagramChannelDemo {
	DatagramChannel channel;

	public ServerDatagramChannelDemo() throws IOException {
		channel = DatagramChannel.open();
		channel.bind(new InetSocketAddress(9999));
		channel.configureBlocking(false);
	}

	public void execute() throws IOException, InterruptedException {
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		byte data[] = new byte[1024];
		String msg = null;
		while (true) {
			channel.receive(buffer);
			buffer.flip();

			int l = buffer.remaining();
			if(l<=0)
			{
				buffer.clear();
				Thread.sleep(100);
				continue;
			}
			
			data = new byte[buffer.remaining()];
			buffer.get(data);
			msg = new String(data, 0, l);
			System.out.println(msg);
			
			buffer.clear();
			
		}

	}

	public static void main(String[] args) throws IOException, InterruptedException {

		new ServerDatagramChannelDemo().execute();
	}
}
