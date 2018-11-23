package inherit.base;

/**
 * 方法自然会被重写,但必须注意变量不会被重写，而是会被保存两份，没有this的就是默认为this的
 * 变量访问规则
 * 		this.变量名:	访问的当前方法所属对象的变量，而不是当前对象的实际类型的变量,即
 * 					父类方法中的this就是访问父类的变量，子类方法的this就是访问子类的变量,用super来访问被子类重名的变量或方法
 * 		
 * 		对象名.变量名:	就是对象当前类型对应类型的变量名
 * 
 * 		对象名.方法名:	就是new对象的方法
 * 
 * 
 * @author jdl
 *
 */
public class Father {
	
	/**
	 * 非静态变量，非静态方法
	 */
	public String name="father";
	/**
	 * 静态变量，非静态方法
	 */
	public static String privilege="抚养";
	/**
	 * 静态变量，静态方法
	 */
	public static int age=40;
	
	/**
	 * 测试子类访问
	 */
	public int weight=100;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setName1(String name) {
		this.name = name;
	}
	
	public void setName2(String name1) {
		name = name1;
	}

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		Father.privilege = privilege;
	}

	public static int getAge() {
		return age;
	}

	public static void setAge(int age) {
		Father.age = age;
	}
	
	@Override
	public String toString() {
		return "fatherStr";
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
