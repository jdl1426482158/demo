package basic.io.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocketChannelTest {

	private int size = 1024;

	public void initChannel() throws IOException, InterruptedException {
		
		ServerSocketChannel socketChannel = ServerSocketChannel.open(); 		// 必须通过静态方法获取，因为本身是抽象类.
		socketChannel.configureBlocking(false);
		socketChannel.bind(new InetSocketAddress(9999));						// socketChannel.socket().bind(new InetSocketAddress(9999));jdk 1.7之前

		ByteBuffer byteBuffer = ByteBuffer.allocate(size);
		while (true) {
			SocketChannel channel = socketChannel.accept();
			if (channel == null) {
				Thread.sleep(100); 												// 因为为非阻塞所以当没有接受到连接时返回为null
				continue;
			}

			channel.configureBlocking(false);									// 获得的SocketChannel默认状态是阻塞的，所以需要通过设置改为非阻塞的状态。

			if (channel != null) {

																				// 输出连接信息
				InetSocketAddress remoteAddress = (InetSocketAddress) channel.getRemoteAddress();
				System.out.println(remoteAddress.getAddress());
				System.out.println(remoteAddress.getPort());

				while (channel.read(byteBuffer) >= 0) { 						// 没有数据返回为零，结束返回-1,连接另一端异常关闭，则回跑出IO异常。

					byteBuffer.flip();											// 切换缓存的模式为从缓存输出；
					while (byteBuffer.hasRemaining()) {
						System.out.print((char) byteBuffer.get());
					}
					byteBuffer.clear(); 										// 清空缓存，并且回复到初始写入状态;

				}
			}
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		new ServerSocketChannelTest().initChannel();
	}
}
