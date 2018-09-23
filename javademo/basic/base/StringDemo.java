package base;

public class StringDemo {
	/*
	 * 字符串本身是无法修改的，再利用+运算符连接字符串的时候， 回有优化，用StringBuilder来操作的，所以不能算操作符重载
	 * 但StringBuilder不是线程安全的，线程安全就需要使用StringBuffer
	 */
	public static void main(String[] args) {
		String s = "This is a test.";
		// 字符串分割
		String ss[] = s.split(" ");
		System.out.println(ss.length);
		for (int i = 0; i < ss.length; i++) {
			System.out.println(ss[i]);
		}
		System.out.println(s.substring(0, 3));

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < ss.length; i++) {
			builder.append(ss[i]);
		}
		System.out.println(builder.toString());

		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < ss.length; i++) {
			buffer.append(ss[i]);
		}
		System.out.println(buffer);

		byte b[] = "Hello, World!".getBytes();

		byte b1[] = new byte[b.length * 2];

		System.arraycopy(b, 0, b1, 0, b.length);

		String msg = new String(b1);

		System.out.println(b1.length + "  " + b.length + "  " + msg.length());
		new String(b1, 0, b.length);
	}
}
