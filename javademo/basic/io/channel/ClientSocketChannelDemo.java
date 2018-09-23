package io.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ClientSocketChannelDemo {
	private int size = 1024*1024;

	public void connectServer() throws IOException {
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.configureBlocking(false);					//���� non-block
		socketChannel.connect(new InetSocketAddress("127.0.0.1", 9999));
		socketChannel.finishConnect();							//��Ϊ�Ƿ�����������û��������Ӿͻ�����ִ�У�������Ҫ�˺�����֤������ɡ�
		ByteBuffer byteBuffer = ByteBuffer.allocate(size);
		while (socketChannel.isConnected()) {
			byteBuffer.put(new String("hello server\n").getBytes());
			byteBuffer.flip();
			while (byteBuffer.hasRemaining()) {
				socketChannel.write(byteBuffer);
			}
			byteBuffer.clear();
		}
		socketChannel.close();					//�ر�ͨ����ͬʱ�ر�IO�����������stream-end,Ȼ��Է�read�ط���-1�����һ��ǿ�ƹرգ����ܳ��쳣
	}

	public static void main(String[] args) throws IOException {
		new ClientSocketChannelDemo().connectServer();
	}
}
