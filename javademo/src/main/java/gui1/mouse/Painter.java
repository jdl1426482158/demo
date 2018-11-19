package gui1.mouse;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;

public class Painter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jf = new JFrame("»­°å");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setBounds(200,300,800,600);
		jf.setVisible(true);
		jf.setResizable(false);
		
		PaintJPanel p=new PaintJPanel();
		p.setBackground(Color.WHITE);
		jf.add(p,BorderLayout.CENTER);
		
		
	}

}
