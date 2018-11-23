package gui2.fail;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class BackFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1043833495308329880L;
	public BackFrame(){
		setBounds(0, 0, 100, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JButton one = new JButton("one");
		one.setBounds(0, 0, 100, 40);
		//使用匿名内部类
		one.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("one");
			}
		});
		
		
		JButton two = new JButton("two");
		two.setBounds(0, 0, 100, 40);
		panel.add(one);
		panel.add(two);
		setContentPane(panel);
		
		JLayeredPane p = getLayeredPane();
		JPanel fpanel = new JPanel();
		p.setLayer(two, 100);
		fpanel.setBackground(Color.RED);
		
		System.out.println(JLayeredPane.getLayer(two));
		setVisible(true);
	}
	public static void main(String[] args){
		new BackFrame();
	}
}
