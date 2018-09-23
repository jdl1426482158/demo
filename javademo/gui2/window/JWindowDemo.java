package window;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.peer.WindowPeer;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.UIManager;
import javax.swing.text.Document;


public class JWindowDemo extends JWindow {

	private Container container;
	Frame f;
	
	public JWindowDemo(Frame frame) {
		super(frame);
		f = frame;
		container = getContentPane();

		iniWindow();

	}
	
	public void iniWindow() {

		container.setBackground(Color.PINK);
		setBounds(100, 100, 400, 300);
		container.setLayout(null);
		setShape(new RoundRectangle2D.Double(10, 10, 200, 200, 50, 50));

		JLabel label = new JLabel("Hello World!");
		label.setBounds(20, 20, 100, 40);
		container.add(label);

		JButton button = new JButton("display");
		button.setBounds(20, 60, 100, 40);
		JPanel panel = new JPanel();
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("pressed");
			}

		});
		container.add(button);
		
		JTextField text = new JTextField("joidjfs");
		text.setBounds(20, 100, 100, 40);
		container.add(text);
		
		setFocusable(true);
		requestFocus();
		setFocusableWindowState(true);
		setAutoRequestFocus(true);
		setFocusTraversalKeysEnabled(true);
		
		container.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				//to make window be able to be on top when it be clicked.
				setAlwaysOnTop(true);//needed to be replaced;
				setAlwaysOnTop(false);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		setVisible(true);

	}

	private JWindowDemo getDemo() {
		return this;
	}

	public static void main(String args[]) {
		Frame  frame= new Frame();
		//frame.setVisible(true);
		new JWindowDemo(frame);
	}

}
