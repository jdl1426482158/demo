package reflect;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.security.Policy.Parameters;

/*
 * ��ʵ������ƾ��ǵ�����jvm�Ľӿڡ�
 */
public class ReflectDemo {
	public static void main(String[] args) throws Exception {
		String s = "slief";
		Class<? extends java.io.Serializable> c = s.getClass();
//		
//		//Modifier�������η���ͨ���鿴Modifier�����֪����Ӧ���η���Ӧ�����η���λ
//				System.out.println(Modifier.toString(c.getModifiers()));
//		
//		//getTypeName���������͵��ַ�������1.8����ֵģ���getName���ص����������ͻ���ת���������
//		System.out.println(new byte[10][10].getClass().getTypeName());
//		System.out.println(new byte[10][10].getClass().getName());
//		//��getName����ͨ������Ƿ����������ƣ�
//		System.out.println(c.getName() + "\n" + c.getTypeName());
//		System.out.println(c.getSimpleName());
//		System.err.println(c.getPackageName());
		
//		//��ȡpublic��Ա����
//		Field fields1[] = c.getFields();
//		for (int i = 0; i < fields1.length; i++) {
//			System.out.printf("%-30s%-30s%-30s\n",
//					Modifier.toString(fields1[i].getModifiers()),
//					fields1[i].getType().getTypeName(),
//					fields1[i].getName());
//		}
//		
//		System.out.println();
		
//		//��ȡ���г�Ա����
//		Field fields[] = c.getDeclaredFields();
//		for (int i = 0; i < fields.length; i++) {
//			System.out.printf("%-30s%-30s%-30s\n",
//					Modifier.toString(fields[i].getModifiers()),
//					fields[i].getType().getTypeName(),
//					fields[i].getName());
//		}
		
		
//		//����˵��������Ҳ����class�ģ������classֻ����������ģ�ֻ��Ϊ�˼��ݣ���ʵû��ʲô��������Ա�����ġ�
//		System.out.println(long.class.field2.length);
//		System.out.println(long.class.getDeclaredMethods().length);
//		System.out.println(long.class.getTypeName());
//		System.out.println(long.class instanceof Object);
//		System.out.println(long.class.toString());
		
//		//��ȡ�ڲ�������ֵ,���ı��ڲ�ֵ����final�����ԵĻ����޷��޸ĵģ�����
//		//field[3]��serialVersionUID���޸��Ǿͻ��ܳ��쳣
//		Field serialVersionUID = fields[2];
//		serialVersionUID.setAccessible(true);					//ʹ��˽�б����ܹ������ʺ��޸�
//		Object o = serialVersionUID.get(s);
//		System.out.println(o);
//		serialVersionUID.set(s, Integer.valueOf(2147483647));
//		o = serialVersionUID.get(s);
//		System.out.println(o);
//		serialVersionUID.setAccessible(false);
		
//		//long.class.getTypeName() ���صĻ���long����ͨ��������ƻ�ȡ��long������Field�������ͱ����Long
//		System.out.println(o.getClass().getTypeName());

		
//		Method methods[] = c.getDeclaredMethods();			//ͬgetFieldsһ��getMethods�Ļ�����ֻ�Ƿ���public�ķ���
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

		
//		//���÷������˽�з���
//		Method methods[] = ReflectDemo_assist.class.getDeclaredMethods();
//		ReflectDemo_assist assist = new ReflectDemo_assist();
//		System.out.println(methods[0].getName());
//		System.out.println(methods[1].getName());
//		methods[1].setAccessible(true);
//		methods[1].invoke(assist);
//		methods[1].setAccessible(false);
	}
}
