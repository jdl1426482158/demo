package basic.io.stream;

import java.io.File;

public class RandomAccessDemo {
	public static void main(String[] args) throws Exception {
		File f = new File("E:\\source\\Adata\\sss.txt");
		if (!f.exists())
			f.createNewFile();

		//错误案例，什么鬼
//		RandomAccessFile access = new RandomAccessFile(f, "rw");
////		byte head[] = { -17, -69, -65 };
////		access.write(head, 0, head.length);
//		access.writeChars("要完啦");
//		access.writeBoolean(true);
//		access.writeChars("哦ion哦比如呢");
//		long pos = access.getFilePointer();
//		access.writeChars("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
	}
}
