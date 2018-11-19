package gui1.applet;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JApplet;

public class Test extends JApplet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7573308033666327663L;
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
