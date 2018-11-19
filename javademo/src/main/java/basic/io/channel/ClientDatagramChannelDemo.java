package basic.io.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class ClientDatagramChannelDemo {

	DatagramChannel channel;

	public ClientDatagramChannelDemo() throws IOException {
		channel = DatagramChannel.open(); 										// 创建通道
		channel.configureBlocking(false); 										// 设置非阻塞

//		 channel.connect(new InetSocketAddress("localhost", 9999));			//假装为连接，其实只是提前设置了电报发送目标地址

	}

	public void send(String msg) throws IOException {
		ByteBuffer buffer = ByteBuffer.allocate(1024);

		buffer.put(msg.getBytes());
		buffer.flip();
		channel.send(buffer, new InetSocketAddress("localhost", 9999)); 		// 发送数据
//		channel.write(buffer);													//对应上面注释掉的代码，假装连接发送数据，但没有保障对方是否收到消息.

	}

	public static void main(String[] args) throws IOException {
		new ClientDatagramChannelDemo().send("New String to write to file..." + System.currentTimeMillis());
	}
}
