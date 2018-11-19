package basic.io.channel;

import java.nio.ByteBuffer;

public class BufferDemo {
	public static void main(String[] args) throws Exception{
		ByteBuffer b = java.nio.ByteBuffer.allocate(10 * 1024 * 1024);
		b.limit(1024 * 1024);
		for (char i = 0; i < 256; i++) {
//			System.out.println(b.position());
//			System.out.println(b.limit());
//			System.out.println(b.capacity());
			b.put((byte) i);
//			System.out.println();
		}
//		System.out.println(b.position());
//		System.out.println(b.limit());
//		System.out.println(b.capacity());

		// ����ȷ��ȡֵ��������õ�0�������Ǵ洢������
		// for (char i = 0; i < 256; i++) {
		// System.out.println(b.position());
		// System.out.println(b.limit());
		// System.out.println(b.capacity());
		// System.out.println("the value is: " + b.get());
		// System.out.println();
		// }
		// System.out.println(b.position());
		// System.out.println(b.limit());
		// System.out.println(b.capacity());
		
		b.flip();
		b.mark();
		byte a;
		int tmp,tmp1;
		for (char i = 0; i < 256; i++) {
			a = b.get();
			tmp = ((int) (a & (byte) 127)) ;
			tmp1 = a >>> (7+24) ;
			System.out.printf("�� %d�������ǣ�%d\n", (int)i,tmp+tmp1*128);
		}
		b.reset();
		for (char i = 0; i < 256; i++) {
			a = b.get();
			tmp = ((int) (a & (byte) 127)) ;
			tmp1 = a >>> (7+24) ;
			System.out.printf("�� %d�������ǣ�%d\n", (int)i,tmp+tmp1*128);
		}
		
		//b.rewind()����ת����д��ģʽ
//		System.out.println(channel.write(src));
	}
}
