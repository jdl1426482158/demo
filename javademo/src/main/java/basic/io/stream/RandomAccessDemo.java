package basic.io.stream;

import java.io.File;

public class RandomAccessDemo {
	public static void main(String[] args) throws Exception {
		File f = new File("E:\\source\\Adata\\sss.txt");
		if (!f.exists())
			f.createNewFile();

		//��������ʲô��
//		RandomAccessFile access = new RandomAccessFile(f, "rw");
////		byte head[] = { -17, -69, -65 };
////		access.write(head, 0, head.length);
//		access.writeChars("Ҫ����");
//		access.writeBoolean(true);
//		access.writeChars("ŶionŶ������");
//		long pos = access.getFilePointer();
//		access.writeChars("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
	}
}
