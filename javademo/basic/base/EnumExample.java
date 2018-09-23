package base;

import java.util.Random;

//enum������һ���������,�����޷����̳к�ʵ��
public enum EnumExample {
	
	//������ʵ��ʼ���Զ����ö�Ӧ���췽������ι������ʡ�����ţ��Զ����public static final claassType 
	StudentA("С��",19,11410300),StudentB,StudentC;
	
	private final String name;
	private int age;
	private final int studentID;
	private Random random = new Random();
	
	//���췽����ע�⣺���췽������Ϊpublic����Ϊenum�������Ա�ʵ����
	private EnumExample(String name,int age,int studentID)
	{
		this.name = name;
		this.studentID = studentID;
		this.age = age;
	}
	
	private EnumExample(){
		this.name = "С"+String.valueOf((char)(random.nextInt(24)+'A'));
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

