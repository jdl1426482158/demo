package imageAndGraphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame extends JFrame{
	
	public Frame()
	{
		ImageIcon image = new ImageIcon("E:/picture/qq.jpg");
		
		System.out.println(image.getIconHeight());
		
		JLabel label = new JLabel(image);
		
		this.getContentPane().add(label);
	}
	
	public static void main(String[] args)
	{
		Frame frame = new Frame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0, 0, 422 , 322);
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	
}
