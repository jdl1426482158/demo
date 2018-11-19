package basic.process;

import java.io.IOException;

/**
 * �������̵����ַ�ʽ
 * 
 * @author BrightSt
 *
 */
public class ProcessDemo {

	public static void main(String[] args) {
		startUpNotepad1();
		startUpNotepad2();
	}

	/**
	 * ����1������Runtime
	 */
	public static void startUpNotepad1() {
		Runtime r = Runtime.getRuntime();// Runtime����һ������
		try {
			r.exec("notepad");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����2������
	 */
	public static void startUpNotepad2() {
		ProcessBuilder pb = new ProcessBuilder("notepad");
		try {
			pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
