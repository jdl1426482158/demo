package a_atest;

import java.lang.*;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.text.Document;

public class Example {
	
	public static void getName(Object...s){
		System.out.println(s.length);
	}
	
	
	
	public static void main(String[] args) {
		String[] b = { "sddf", "verg", "sdberb" };
		Class<? extends String> cl = b[1].getClass();
		System.out.println(cl.getName());
		Method[] m = cl.getDeclaredMethods();
		for (Method mm : m) {
			System.out.printf(String.format("%-25s%s\n",
					Modifier.toString(mm.getModifiers()), mm.getName()));
		}
		getName("sbsb","sewew");
	}
}