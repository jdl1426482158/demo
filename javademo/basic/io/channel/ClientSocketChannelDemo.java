package io.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ClientSocketChannelDemo {
	private int size = 1024*1024;

	public void connectServer() throws IOException {
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.configureBlocking(false);					//设置 non-block
		socketChannel.connect(new InetSocketAddress("127.0.0.1", 9999));
		socketChannel.finishConnect();							//因为是非阻塞，所以没有完成连接就会往下执行，所以需要此函数保证连接完成。
		ByteBuffer byteBuffer = ByteBuffer.allocate(size);
		while (socketChannel.isConnected()) {
			byteBuffer.put(new String("hello server\n").getBytes());
			byteBuffer.flip();
			while (byteBuffer.hasRemaining()) {
				socketChannel.write(byteBuffer);
			}
			byteBuffer.clear();
		}
		socketChannel.close();					//关闭通道，同时关闭IO，即向流输出stream-end,然后对方read回返回-1；如果一方强制关闭，会跑出异常
	}

	public static void main(String[] args) throws IOException {
		new ClientSocketChannelDemo().connectServer();
	}
}
