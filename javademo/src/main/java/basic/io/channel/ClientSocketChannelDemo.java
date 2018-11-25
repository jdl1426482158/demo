package basic.io.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ClientSocketChannelDemo {
	private int size = 1024 * 1024;

	public void connectServer() throws IOException {

		// 创建通道
		SocketChannel socketChannel = SocketChannel.open();
		// 设置非阻塞
		socketChannel.configureBlocking(false); // 设置 non-block
		// 建立连接
		socketChannel.connect(new InetSocketAddress("127.0.0.1", 9999));
		// 主动等待连接完成
		socketChannel.finishConnect(); // 因为是非阻塞，所以没有完成连接就会往下执行，所以需要此函数保证连接完成。

		// 设置缓存
		ByteBuffer byteBuffer = ByteBuffer.allocate(size);
		// 设置计数器
		int count = 0;
		try {
			while (socketChannel.isConnected() && count < 10) {
				byteBuffer.put(new String("hello server\n").getBytes());
				byteBuffer.flip();
				while (byteBuffer.hasRemaining()) {
					socketChannel.write(byteBuffer);
				}
				byteBuffer.clear();
				count++;
			}
			System.out.println("连接正常结束");
		} catch (Exception e) {
			System.err.println("连接异常，被迫终止");
		} finally {
			socketChannel.close(); // 关闭通道，同时关闭IO，即向流输出stream-end,然后对方read回返回-1；如果一方强制关闭，会跑出异常
		}
	}

	public static void main(String[] args) throws IOException {
		new ClientSocketChannelDemo().connectServer();
	}
}
