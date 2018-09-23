package applet;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JApplet;

public class Test extends JApplet{

	Image img;
	
	public void init()
	{
		img=getImage(getCodeBase(),"baby.jpg");
		if(img==null)
			System.out.println("hello");
	}
	
	public void paint(Graphics g)
	{
		g.drawImage(img, 100, 100, this);
		//g.drawString("hello", 100,100 );
	}
}
