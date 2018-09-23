package io.stream;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/*
 * ObjectOutputStream在写入的时候会加一个头，导致连续写入两次的时候回出错
 * 所以多次写入的时候要重写writeStreamHeader方法，使其不被调用当文件存在头时
 */

public class FileObjectStream {
	public static void copyFile(File f1, File f2) throws Exception {
		if (!f2.exists())
			f2.createNewFile();

		Object buffer[] = FileObjectStream.readObject(f1);
		for (int i = 0; i < buffer.length; i++) {
			FileObjectStream.saveObject(f2, buffer[i]);
		}
		String msg = null;
		if (f1.length() == f2.length())
			msg = "Copying file is successful.";
		else
			msg = "Copying file is failed.";
		System.out.println(msg);
	}

	public static void main(String[] args) throws Exception {
		File f1 = new File("E:\\source\\data\\object");
		File f2 = new File("E:\\source\\data\\object_copy");

		// 准备内容
		if (!f1.exists()) {
			f1.createNewFile();
			String s = "Hello, World!";
			String s1 = "Happy New Year!";
			Integer a = Integer.valueOf(38738409);
			FileObjectStream.saveObject(f1, s);
			FileObjectStream.saveObject(f1, f1);
			FileObjectStream.saveObject(f1, a);
			FileObjectStream.saveObject(f1, f2);
			FileObjectStream.saveObject(f1, s1);
		}

		FileObjectStream.copyFile(f1, f2);
		// String s = "Hello, World!";
		// FileObjectStream.saveObject(f1, s);
	}

	public static void saveObject(File f1, Object o) {
		try {
			if (!f1.exists())
				f1.createNewFile();

			ObjectOutputStream out;
			if (f1.length() < 1)
				out = new ObjectOutputStream(new FileOutputStream(f1, true));
			else
				out = new FileObjectOutputStream(new FileOutputStream(f1, true));
			out.writeObject(o);
			out.flush();
			out.close();
		} catch (Exception e) {
			// 不考虑异常情况，故不做处理
		}
	}

	// 读取结束时候回放出EOFException
	public static Object[] readObject(File f1) {
		ArrayList<Object> list = new ArrayList<Object>();
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(f1));

			while (true) {
				try {
					list.add(in.readObject());
				} catch (EOFException e) {
					in.close();
					break;
				}
			}
		} catch (Exception e) {
			// 出错就不读还不行嘛
		}
		return list.toArray();
	}

	// 因为2次及以上对象输入时由于会多次添加Header所以必须去掉header才行
	private static class FileObjectOutputStream extends ObjectOutputStream {
		public FileObjectOutputStream(OutputStream out) throws IOException {
			super(out);
		}

		@Override
		protected void writeStreamHeader() throws IOException {
			return;
		}

	}

}
