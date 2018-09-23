package systemData;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class NowString {
	public static void main(String[] args) throws InterruptedException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		DateFormat date=df.getDateInstance();
		
	}
}