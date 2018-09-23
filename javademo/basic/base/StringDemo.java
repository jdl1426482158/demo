package base;

public class StringDemo {
	/*
	 * �ַ����������޷��޸ĵģ�������+����������ַ�����ʱ�� �����Ż�����StringBuilder�������ģ����Բ��������������
	 * ��StringBuilder�����̰߳�ȫ�ģ��̰߳�ȫ����Ҫʹ��StringBuffer
	 */
	public static void main(String[] args) {
		String s = "This is a test.";
		// �ַ����ָ�
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
