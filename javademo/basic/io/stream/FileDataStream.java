package io.stream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileDataStream {
	
	public static void copyFile(File f1,File f2)
	{
		try {
			if (!f2.exists())
				f2.createNewFile();
			DataInputStream in = new DataInputStream(new FileInputStream(f1));
			DataOutputStream out = new DataOutputStream(new FileOutputStream(f2));
			String buffer = null;
			while (true) {
				try {
				buffer = in.readUTF();
				out.writeUTF(buffer);
				out.flush();
				}catch(EOFException e)
				{
					in.close();
					out.close();
					System.out.println("Copying file is successful.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Copying file is failed.");
		}
	}
	
	public static void copyFile1(File f1, File f2) {
		try {
			if (!f2.exists())
				f2.createNewFile();

			DataInputStream in = new DataInputStream(new FileInputStream(f1));
			DataOutputStream out = new DataOutputStream(new FileOutputStream(f2));
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
		File f1 = new File("E:\\source\\data\\1.txt");
		File f2 = new File("E:\\source\\data\\1_copy.txt");
		FileIOStream.copyFile(f1, f2);
	}
}
