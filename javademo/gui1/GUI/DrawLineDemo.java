package GUI;

import java.awt.Color;

import javax.swing.JFrame;

public class DrawLineDemo {

	public static void main(String[] arg0) {
		// TODO Auto-generated method stub
		JFrame frame= new JFrame("hello");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0, 0, 400, 400);
		frame.setBackground(Color.WHITE);
		
		DrawLineTest panel= new DrawLineTest();
		frame.add(panel);
		frame.setVisible(true);
		
	}

}
