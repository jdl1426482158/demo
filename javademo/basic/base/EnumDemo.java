package base;

public class EnumDemo {
	public static void main(String[] args) {
		// EnumExample e = EnumExample.StudentA;
		// Class<?> c = e.getClass();
		// System.out.println(c.getName());
		// System.out.println("enum������" + e instanceof Object);//Ϊë���ѼӺ�ǰ�沿�ָ�����Ūû�˰�
		// System.out.println("enum�Ǽ̳���java.lange.Enum ��" + String.valueOf(e instanceof
		// Enum));
		// System.out.println(EnumExample.StudentB.getName());
		// System.out.println(EnumExample.StudentA.name());

		System.out.println(EnumExample_Operation.PLUS.eval(3.4, 2.7));
		System.out.println(EnumExample_Operation.DIVIDE.eval(3.4, 2.7));
		System.out.println(EnumExample_Operation.MINUS.eval(3.4, 2.7));
		System.out.println(EnumExample_Operation.TIMES.eval(3.4, 2.7));
	}
}
