package reflect;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.security.Policy.Parameters;

/*
 * 其实反射机制就是调用了jvm的接口。
 */
public class ReflectDemo {
	public static void main(String[] args) throws Exception {
		String s = "slief";
		Class<? extends java.io.Serializable> c = s.getClass();
//		
//		//Modifier就是修饰符，通过查看Modifier类可以知道相应修饰符对应的修饰符的位
//				System.out.println(Modifier.toString(c.getModifiers()));
//		
//		//getTypeName是数据类型的字符串，但1.8后出现的，而getName返回的是数据类型或则转换后的名称
//		System.out.println(new byte[10][10].getClass().getTypeName());
//		System.out.println(new byte[10][10].getClass().getName());
//		//但getName对普通的类就是返回数据名称；
//		System.out.println(c.getName() + "\n" + c.getTypeName());
//		System.out.println(c.getSimpleName());
//		System.err.println(c.getPackageName());
		
//		//获取public成员变量
//		Field fields1[] = c.getFields();
//		for (int i = 0; i < fields1.length; i++) {
//			System.out.printf("%-30s%-30s%-30s\n",
//					Modifier.toString(fields1[i].getModifiers()),
//					fields1[i].getType().getTypeName(),
//					fields1[i].getName());
//		}
//		
//		System.out.println();
		
//		//获取所有成员变量
//		Field fields[] = c.getDeclaredFields();
//		for (int i = 0; i < fields.length; i++) {
//			System.out.printf("%-30s%-30s%-30s\n",
//					Modifier.toString(fields[i].getModifiers()),
//					fields[i].getType().getTypeName(),
//					fields[i].getName());
//		}
		
		
//		//就是说基本类型也是有class的，但这个class只是象征意义的，只是为了兼容，其实没有什么方法，成员变量的。
//		System.out.println(long.class.field2.length);
//		System.out.println(long.class.getDeclaredMethods().length);
//		System.out.println(long.class.getTypeName());
//		System.out.println(long.class instanceof Object);
//		System.out.println(long.class.toString());
		
//		//获取内部变量的值,并改变内部值，但final的属性的还是无法修改的，比如
//		//field[3]即serialVersionUID，修改是就会跑出异常
//		Field serialVersionUID = fields[2];
//		serialVersionUID.setAccessible(true);					//使得私有变量能够被访问和修改
//		Object o = serialVersionUID.get(s);
//		System.out.println(o);
//		serialVersionUID.set(s, Integer.valueOf(2147483647));
//		o = serialVersionUID.get(s);
//		System.out.println(o);
//		serialVersionUID.setAccessible(false);
		
//		//long.class.getTypeName() 返回的还是long，但通过反射机制获取到long变量的Field则起类型编程了Long
//		System.out.println(o.getClass().getTypeName());

		
//		Method methods[] = c.getDeclaredMethods();			//同getFields一样getMethods的话，就只是返回public的方法
//		for (int i = 0; i < methods.length; i++) {
//			if(i!=0)
//				System.out.println("-----------------------------------------------------------------------"+
//						"-----------------------------------------------------------------------");
//			System.out.printf("%-30s%-30s%-30s\n",
//			Modifier.toString(methods[i].getModifiers()),
//			methods[i].getReturnType().getTypeName(),
//			methods[i].getName());
//			
//			Parameter paras[] = methods[i].getParameters();
//			for (int j = 0; j < paras.length; j++) {
//				System.out.printf("%-60s%-30s%-30s%-30s\n",
//						" ",
//						Modifier.toString(paras[j].getModifiers()),
//						paras[j].getType().getTypeName(),
//						paras[0].getName());
//			}		
//		}

		
//		//利用反射调用私有方法
//		Method methods[] = ReflectDemo_assist.class.getDeclaredMethods();
//		ReflectDemo_assist assist = new ReflectDemo_assist();
//		System.out.println(methods[0].getName());
//		System.out.println(methods[1].getName());
//		methods[1].setAccessible(true);
//		methods[1].invoke(assist);
//		methods[1].setAccessible(false);
	}
}
