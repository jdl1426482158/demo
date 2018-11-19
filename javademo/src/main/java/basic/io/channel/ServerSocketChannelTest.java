package basic.io.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocketChannelTest {

	private int size = 1024;

	public void initChannel() throws IOException, InterruptedException {
		
		ServerSocketChannel socketChannel = ServerSocketChannel.open(); 		// ����ͨ����̬������ȡ����Ϊ�����ǳ�����.
		socketChannel.configureBlocking(false);
		socketChannel.bind(new InetSocketAddress(9999));						// socketChannel.socket().bind(new InetSocketAddress(9999));jdk 1.7֮ǰ

		ByteBuffer byteBuffer = ByteBuffer.allocate(size);
		while (true) {
			SocketChannel channel = socketChannel.accept();
			if (channel == null) {
				Thread.sleep(100); 												// ��ΪΪ���������Ե�û�н��ܵ�����ʱ����Ϊnull
				continue;
			}

			channel.configureBlocking(false);									// ��õ�SocketChannelĬ��״̬�������ģ�������Ҫͨ�����ø�Ϊ��������״̬��

			if (channel != null) {

																				// ���������Ϣ
				InetSocketAddress remoteAddress = (InetSocketAddress) channel.getRemoteAddress();
				System.out.println(remoteAddress.getAddress());
				System.out.println(remoteAddress.getPort());

				while (channel.read(byteBuffer) >= 0) { 						// û�����ݷ���Ϊ�㣬��������-1,������һ���쳣�رգ�����ܳ�IO�쳣��

					byteBuffer.flip();											// �л������ģʽΪ�ӻ��������
					while (byteBuffer.hasRemaining()) {
						System.out.print((char) byteBuffer.get());
					}
					byteBuffer.clear(); 										// ��ջ��棬���һظ�����ʼд��״̬;

				}
			}
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		new ServerSocketChannelTest().initChannel();
	}
}
