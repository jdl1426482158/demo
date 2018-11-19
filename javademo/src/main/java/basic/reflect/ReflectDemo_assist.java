package basic.reflect;

public class ReflectDemo_assist {
	private void print() {
		System.out.println("private");
	}
	
	public static void main(String[] args) {
		new ReflectDemo_assist().print();
	}
}
