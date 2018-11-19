package basic.process;

import java.io.IOException;

/**
 * 启动进程的两种方式
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
	 * 方法1：利用Runtime
	 */
	public static void startUpNotepad1() {
		Runtime r = Runtime.getRuntime();// Runtime类是一个单例
		try {
			r.exec("notepad");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 方法2：利用
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
