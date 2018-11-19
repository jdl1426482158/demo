package gui1.imageAndGraphics;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyJPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8608189219823453793L;

	public void paintComponent(Graphics g)
	{
		ImageIcon icon=new ImageIcon("s.jpg");
		Image image=icon.getImage();
		g.drawImage(image, 0, 0, null);
	}

}
