package base;

public class DefaultClass {
//默认类只能再同一个包内访问
	static class SSS {
		public static void print() {
			System.out.println("I want you!");
		}
	}

	final static String s = "L is the best!";

}

class SSS {
	public static void print() {
		System.out.println("I want you!");
	}
}