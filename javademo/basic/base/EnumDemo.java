package base;

public class EnumDemo {
	public static void main(String[] args) {
		// EnumExample e = EnumExample.StudentA;
		// Class<?> c = e.getClass();
		// System.out.println(c.getName());
		// System.out.println("enum是类吗" + e instanceof Object);//为毛啊把加号前面部分给好像弄没了啊
		// System.out.println("enum是继承了java.lange.Enum 了" + String.valueOf(e instanceof
		// Enum));
		// System.out.println(EnumExample.StudentB.getName());
		// System.out.println(EnumExample.StudentA.name());

		System.out.println(EnumExample_Operation.PLUS.eval(3.4, 2.7));
		System.out.println(EnumExample_Operation.DIVIDE.eval(3.4, 2.7));
		System.out.println(EnumExample_Operation.MINUS.eval(3.4, 2.7));
		System.out.println(EnumExample_Operation.TIMES.eval(3.4, 2.7));
	}
}
