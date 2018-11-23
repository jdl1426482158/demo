/*
 * Arrays是List的辅助类
 * 
 * 
 * 
 */
package basic.data.struct;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jdl
 * time: 2018年11月11日 下午2:02:58
 */
public class ListDemo {
	public static void main(String[] args) {
		Set<String> set;
		set = new HashSet<String>();
		set.add("hello");
		set.add("world");
		Object[] array = set.toArray();
		for (Object object : array) {
			System.out.println(object.toString());
		}
	}
}
