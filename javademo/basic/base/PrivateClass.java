package base;

public class PrivateClass {
//privateֻ�������ڲ��࣬���������ⲿ��,private��ֻ�ܱ��ڲ�����
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
