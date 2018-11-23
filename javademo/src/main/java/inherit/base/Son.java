package inherit.base;

/**
 * @author jdl
 *
 */
public class Son extends Father {
	public String name = "son";
	public static String privilege = "被抚养";
	public static int age = 16;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		Son.privilege = privilege;
	}

	public static int getAge() {
		return age;
	}

	public static void setAge(int age) {
		Son.age = age;
	}

	@Override
	public String toString() {
		return "sonStr";
	}
	
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public void setSuperName(String name) {
		super.name = name;
	}
}
