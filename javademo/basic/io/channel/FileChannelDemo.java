package io.channel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo {
	/*
	 * 文件通道都是阻塞形的，好像
	 * 
	 */
	
	
	public static void main(String[] args) throws IOException {

		String msg = "这是一个测试";
		byte mb[] = msg.getBytes();

		File f = new File("E:\\source\\file\\channel.txt");
		if (!f.exists())
			f.createNewFile();

		FileOutputStream out = new FileOutputStream(f);
		FileChannel channel = out.getChannel();

		ByteBuffer buffer = ByteBuffer.allocate(4 * 1024);
		buffer.put(mb); // 将数据写入buffer中
		
		buffer.flip();
		channel.write(buffer); // 输出之前必须转换成写的模式
		out.close();

		FileInputStream in = new FileInputStream(f);
		byte b[] = new byte[mb.length];

		channel = in.getChannel(); // 由于前面的输出流所以得到的也是只能输出的单向通道
		buffer.rewind(); // 将buffer重新设为写模式
		channel.read(buffer); // 读取数据并写入buffer中
		buffer.flip();
		buffer.get(b); // 从buffer中获得数据
		System.out.println(new String(b));
		in.close();
	}
}
