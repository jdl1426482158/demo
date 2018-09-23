package mouse;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ButtonMouse extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7332566642741859694L;
	private JButton jb;
	public ButtonMouse(){
		
		setBounds(200, 100,800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jb=new JButton("yes");
		jb.setSize(40, 30);
		
		jb.addMouseWheelListener(
				new MouseWheelListener(){

					@Override
					public void mouseWheelMoved(MouseWheelEvent e) {
						// TODO Auto-generated method stub
						System.out.println(e.isAltDown());
						System.out.println(e.getModifiers());
					}
					
				});
		
		add(jb, BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ButtonMouse().setVisible(true);;
	}

}
