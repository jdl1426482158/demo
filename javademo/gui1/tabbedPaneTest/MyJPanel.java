package tabbedPaneTest;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyJPanel extends JPanel{
	
	private JTextField textField;
	private File file=new File("hello.jpg");
	
	public MyJPanel()
	{
		setLayout(null);
		
		textField=new JTextField();
		textField.setBounds(0, 0, 100, 20);
		
		add(textField);
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Image picture = null;
		try{
			picture=ImageIO.read(new File("D:/hello.jpg"));
		}catch(IOException e)
		{
			System.out.println("hello");
			e.printStackTrace();
		}
		g.drawImage(picture,0, 20, null);
	}
	public String getText()
	{
		return textField.getText();
	}
}
