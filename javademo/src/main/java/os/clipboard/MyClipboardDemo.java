package os.clipboard;

import java.awt.Toolkit;
import java.awt.datatransfer.*;

public class MyClipboardDemo implements ClipboardOwner{
	
	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
	}
		
	public static void main(String args[]) throws Exception
	{
		
		//实现的功能是剪贴版，粘贴一次后更新剪贴版
		Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
		MyClipboardDemo owner = new MyClipboardDemo();
		String address = "https://www.cs.utexas.edu/users/byoung/cs361/lecture"; 
		String str = "",end = ".pdf";
		StringSelection content = null;
		
		for(int i = 5;i<=80;i++)
		{
			str = address+String.valueOf(i)+end;
			content = new StringSelection(str);
			clip.setContents(content,owner);
			content = null;
			Thread.sleep(1000);
		}
		
		
	}
}
