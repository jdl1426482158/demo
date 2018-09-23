package fail;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class BackFrame extends JFrame{

	public BackFrame(){
		setBounds(0, 0, 100, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JButton one = new JButton("one");
		one.setBounds(0, 0, 100, 40);
		//ʹ�������ڲ���
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
		
		System.out.println(p.getLayer(two));
		setVisible(true);
	}
	public static void main(String[] args){
		new BackFrame();
	}
}
