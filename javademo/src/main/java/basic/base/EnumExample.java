package basic.base;

import java.util.Random;

//enum本身是一个特殊的类,并且无法被继承和实现
public enum EnumExample {
	
	//常量其实初始化自动调用对应构造方法，误参构造可以省略括号，自动添加public static final claassType 
	StudentA("小红",19,11410300),StudentB,StudentC;
	
	private final String name;
	private int age;
	private final int studentID;
	private Random random = new Random();
	
	//构造方法，注意：构造方法不能为public，因为enum并不可以被实例化
	private EnumExample(String name,int age,int studentID)
	{
		this.name = name;
		this.studentID = studentID;
		this.age = age;
	}
	
	private EnumExample(){
		this.name = "小"+String.valueOf((char)(random.nextInt(24)+'A'));
		this.studentID = random.nextInt(99)+11410300;
		this.age = random.nextInt(99);
	}
	
	public String getName(){
		return name;
	}
	
	public int getID(){
		return studentID;
	}
	
	public int getAge(){
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}

