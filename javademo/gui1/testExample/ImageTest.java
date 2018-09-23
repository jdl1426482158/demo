package testExample;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageTest extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image picture;
	private File file;
	public ImageTest()
	{
		
	}
	
	public void paintComponent(Graphics g)
	{
		
			file=new File("F:/picture/hello.jpg");
			try{
				picture=ImageIO.read(file);
			}catch(IOException e)
			{
				e.printStackTrace();
			}
			ImageObserver observer=null;
			g.drawImage(picture, 0, 0, picture.getHeight(getParent()), picture.getWidth(getParent()), observer);
	}
	public static void main(String arg0[])
	{
		JFrame frame=new JFrame("ImageTest");
		frame.setBounds(0, 0, 1300, 780);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageTest it=new ImageTest();
		
		frame.add(it);
		frame.setVisible(true);
	}
}
