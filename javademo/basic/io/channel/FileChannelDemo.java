package io.channel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo {
	/*
	 * �ļ�ͨ�����������εģ�����
	 * 
	 */
	
	
	public static void main(String[] args) throws IOException {

		String msg = "����һ������";
		byte mb[] = msg.getBytes();

		File f = new File("E:\\source\\file\\channel.txt");
		if (!f.exists())
			f.createNewFile();

		FileOutputStream out = new FileOutputStream(f);
		FileChannel channel = out.getChannel();

		ByteBuffer buffer = ByteBuffer.allocate(4 * 1024);
		buffer.put(mb); // ������д��buffer��
		
		buffer.flip();
		channel.write(buffer); // ���֮ǰ����ת����д��ģʽ
		out.close();

		FileInputStream in = new FileInputStream(f);
		byte b[] = new byte[mb.length];

		channel = in.getChannel(); // ����ǰ�����������Եõ���Ҳ��ֻ������ĵ���ͨ��
		buffer.rewind(); // ��buffer������Ϊдģʽ
		channel.read(buffer); // ��ȡ���ݲ�д��buffer��
		buffer.flip();
		buffer.get(b); // ��buffer�л������
		System.out.println(new String(b));
		in.close();
	}
}
