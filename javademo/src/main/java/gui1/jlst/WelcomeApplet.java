package gui1.jlst;
import java.awt.Graphics;

import javax.swing.JApplet;
public class WelcomeApplet extends JApplet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paint(Graphics g){
		super.paint(g);
		
		g.drawString("Welcome to Java Programming!",25,25);
	}

}
