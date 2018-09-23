package io.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileIOStream {
	public static void copyFile(File f1, File f2) {
		try {
			if (!f2.exists())
				f2.createNewFile();
			
			InputStream in = new FileInputStream(f1);
			OutputStream out = new FileOutputStream(f2);
			byte buffer[] = new byte[4 * 1024];
			int length = 0;
			
			while ((length = in.read(buffer)) != -1) {
				out.write(buffer, 0, length);
				out.flush();
			}
			in.close();
			out.close();
			System.out.println("Copying file is successful.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Copying file is failed.");
		}
	}

	public static void main(String[] args) {
		File f1 = new File("E:\\source\\data\\1.jpg");
		File f2 = new File("E:\\source\\data\\1_copy.jpg");
		FileIOStream.copyFile(f1, f2);
	}

}
