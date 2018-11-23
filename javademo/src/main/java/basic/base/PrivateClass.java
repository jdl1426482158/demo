package basic.base;

public class PrivateClass {
//private只能修饰内部类，不能修饰外部类,private类只能被内部访问
	private static class Fruit{
		private String name;
		private int weight;
		
		public Fruit(String n,int w) {
			this.name = n;
			this.weight = w;
		}
		public String getName() {
			return name;
		}
		public int getWeight() {
			return weight;
		}
		
	}
	
	public static void main(String argv[])
	{
		Fruit f1 = new Fruit("apple",560);
		System.out.println(f1.getName());
		System.out.println(f1.getWeight());
	}
	
}
