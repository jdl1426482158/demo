package inherit.base;

/**
 * 测试静态与非静态方法，变量的重写问题，明确的有this不能访问静态变量
 * 
 * @author jdl
 *
 */
public class Test {
	public static void main(String[] args) {
		Father father = new Father();
		Father son = new Son();
		Son son1 = (Son) son;
		Son son2 = new Son();
		System.out.println(father.name);
		System.out.println(father.getName());
		System.out.println(father.privilege);
		System.out.println(father.getPrivilege());
		System.out.println(father.age);
		System.out.println(father.getAge());
		System.out.println(father.weight);
		System.out.println(father.getWeight());
		System.out.println(father);
		System.out.println("---------------------------------------------------");
		System.out.println(son.name);
		System.out.println(son.getName());
		System.out.println(son.privilege);
		System.out.println(son.getPrivilege());
		System.out.println(son.age);
		System.out.println(son.getAge());
		System.out.println(son.weight);
		System.out.println(son.getWeight());
		System.out.println(son);
		System.out.println("---------------------------------------------------");
		System.out.println(son1.name);
		System.out.println(son1.getName());
		System.out.println(son1.privilege);
		System.out.println(son1.getPrivilege());
		System.out.println(son1.age);
		System.out.println(son1.getAge());
		System.out.println(son1.weight);
		System.out.println(son1.getWeight());
		System.out.println(son1);
		System.out.println("---------------------------------------------------");
		System.out.println(son2.name);
		System.out.println(son2.getName());
		System.out.println(son2.privilege);
		System.out.println(son2.getPrivilege());
		System.out.println(son2.age);
		System.out.println(son2.getAge());
		System.out.println(son2.weight);
		System.out.println(son2.getWeight());
		System.out.println(son2);
		
		//修改影响
		System.out.println("---------------------------------------------------");
		son.name = "he";
		System.out.println(son.name);
		System.out.println(son.getName());
		System.out.println(son1.name);
		System.out.println(son1.getName());
		//修改回数据
		son.name = "father";
		
		//修改影响
		System.out.println("---------------------------------------------------");
		son1.name = "he";
		System.out.println(son.name);
		System.out.println(son.getName());
		System.out.println(son1.name);
		System.out.println(son1.getName());
		//修改回数据
		son1.name = "father";
		
		//修改影响
		System.out.println("---------------------------------------------------");
		son.setName("he");
		System.out.println(son.name);
		System.out.println(son.getName());
		System.out.println(son1.name);
		System.out.println(son1.getName());
		//修改回数据
		son.setName("son");
		
		//修改影响
		//这里证明方法中的this
		//		父子类包含同一个属性名时，子类优先访问访问子类的成员变量
		System.out.println("---------------------------------------------------");
		son1.setSuperName("he");
		System.out.println(son.name);
		System.out.println(son.getName());
		System.out.println(son1.name);
		System.out.println(son1.getName());
		//修改回数据
		son1.setSuperName("father");
		
		//修改影响
		System.out.println("---------------------------------------------------");
		son.setName1("he");
		System.out.println(son.name);
		System.out.println(son.getName());
		System.out.println(son1.name);
		System.out.println(son1.getName());
		//修改回数据
		son.setName1("son");
		
		//修改影响
		System.out.println("---------------------------------------------------");
		son1.setName2("he");
		System.out.println(son.name);
		System.out.println(son.getName());
		System.out.println(son1.name);
		System.out.println(son1.getName());
		//修改回数据
		son1.setName2("son");
	}
}
