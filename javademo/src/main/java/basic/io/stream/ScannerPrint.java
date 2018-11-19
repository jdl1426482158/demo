package basic.io.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;



public class ScannerPrint {
	public static void copyFile(File f1, File f2) {
		try {
			if (!f2.exists())
				f2.createNewFile();
			
			Scanner in = new Scanner(new FileInputStream(f1)) ;
			PrintStream out = new PrintStream(new FileOutputStream(f2));
			
			String buffer = null;
//			int length = 0;
			
			while (in.hasNextLine()) {
				buffer = in.nextLine();
				out.println(buffer);
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
		ScannerPrint.copyFile(f1, f2);
	}
}
