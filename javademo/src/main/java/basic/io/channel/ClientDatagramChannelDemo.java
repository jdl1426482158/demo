package basic.io.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class ClientDatagramChannelDemo {

	DatagramChannel channel;

	public ClientDatagramChannelDemo() throws IOException {
		channel = DatagramChannel.open(); 										// ����ͨ��
		channel.configureBlocking(false); 										// ���÷�����

//		 channel.connect(new InetSocketAddress("localhost", 9999));			//��װΪ���ӣ���ʵֻ����ǰ�����˵籨����Ŀ���ַ

	}

	public void send(String msg) throws IOException {
		ByteBuffer buffer = ByteBuffer.allocate(1024);

		buffer.put(msg.getBytes());
		buffer.flip();
		channel.send(buffer, new InetSocketAddress("localhost", 9999)); 		// ��������
//		channel.write(buffer);													//��Ӧ����ע�͵��Ĵ��룬��װ���ӷ������ݣ���û�б��϶Է��Ƿ��յ���Ϣ.

	}

	public static void main(String[] args) throws IOException {
		new ClientDatagramChannelDemo().send("New String to write to file..." + System.currentTimeMillis());
	}
}
