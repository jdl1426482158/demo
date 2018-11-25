package basic.io.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocketChannelTest {

	private int size = 1024;

	public void initChannel() throws IOException, InterruptedException {

		// 创建通道
		ServerSocketChannel socketChannel = ServerSocketChannel.open(); // 必须通过静态方法获取，因为本身是抽象类.
		// 设置非阻塞
		socketChannel.configureBlocking(false);
		// 监听端口
		socketChannel.bind(new InetSocketAddress(9999)); // socketChannel.socket().bind(new InetSocketAddress(9999));jdk
															// 1.7之前
		// 设置缓存
		ByteBuffer byteBuffer = ByteBuffer.allocate(size);
		// 循环接受连接
		while (true) {
			SocketChannel channel = socketChannel.accept();
			// 等待真实连接，排除空连接
			if (channel == null) {
				Thread.sleep(100); // 因为为非阻塞所以当没有接受到连接时返回为null
				continue;
			}

			// 设置客户端连接为非阻塞
			channel.configureBlocking(false); // 获得的SocketChannel默认状态是阻塞的，所以需要通过设置改为非阻塞的状态。

			// 输出链接信息
			InetSocketAddress remoteAddress = (InetSocketAddress) channel.getRemoteAddress();
			System.out.println(remoteAddress.getAddress());
			System.out.println(remoteAddress.getPort());

			// 接受连接数据，并捕捉异常关闭的连接
			try {
				
				// 循环接受数据
				while (channel.read(byteBuffer) >= 0) { // 没有数据返回为零，结束返回-1,连接另一端异常关闭，则回跑出IO异常。
					// 切换缓存的模式为从缓存输出；
					byteBuffer.flip(); 
					while (byteBuffer.hasRemaining()) {
						System.out.print((char) byteBuffer.get());
					}
					// 清空缓存，并且回复到初始写入状态;
					byteBuffer.clear(); 
				}
				
				// 输出结束状态
				System.out.println("正常关闭一个链接");
			} catch (Exception e) {
				System.err.println("\n异常关闭一个链接");
				e.printStackTrace();
			} finally {
				channel.close();
			}
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		new ServerSocketChannelTest().initChannel();
	}
}
