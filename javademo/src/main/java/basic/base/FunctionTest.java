package basic.base;

public class FunctionTest {

	

	private static class T {
		int a = 3;
		public void setValue(int i) {
			a = i;
		}

		public void printValue() {
			System.out.println(a);
		}

	}

	public void setValue(T i) {
		i.setValue(123);
	}

	public static void main(String[] args) {
		T t = new T();
		new FunctionTest().setValue(t);
		t.printValue();
	}
}
