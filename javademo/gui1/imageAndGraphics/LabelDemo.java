package imageAndGraphics;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LabelDemo {
	public static void main(String[] args)
	{
		JLabel northLabel = new JLabel("North");
		
		ImageIcon labelIcon = new ImageIcon("s.jpg");
		
		JLabel centerLabel = new JLabel(labelIcon);
		
		JLabel southLabel =new JLabel(labelIcon);
		
		southLabel.setText("south");
		
		MyJPanel panel=new MyJPanel();
		
		JFrame application = new JFrame();
		
		application.add(northLabel,BorderLayout.NORTH);
		application.add(centerLabel,BorderLayout.CENTER);
		application.add(southLabel,BorderLayout.SOUTH);
		application.add(panel,BorderLayout.CENTER);
		
		application.setSize(300, 300);
		application.setVisible(true);
	}
}
