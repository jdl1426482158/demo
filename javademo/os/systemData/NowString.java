package systemData;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class NowString {
	public static void main(String[] args) throws InterruptedException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
		System.out.println(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
		DateFormat date=df.getDateInstance();
		
	}
}