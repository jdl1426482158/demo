package basic.io.stream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class FileReaderWriter {
	public static void copyFile(File f1, File f2) {
		try {
			if (!f2.exists())
				f2.createNewFile();
			
			Reader in = new FileReader(f1);
			Writer out = new FileWriter(f2);
			char buffer[] = new char[4 * 1024];
			int length = 0;
			
			while ((length = in.read(buffer)) != -1) {
				out.write(buffer, 0, length);
				out.flush();
			}
			in.close();
			out.close();
			System.out.println("Copying file is successful");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Copying file is failed.");
		}
	}

	public static void main(String[] args) {
		File f1 = new File("E:\\source\\data\\1.txt");
		File f2 = new File("E:\\source\\data\\1_copy.txt");
		FileReaderWriter.copyFile(f1, f2);
	}

}
