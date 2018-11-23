package gui1.testExample;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
public class CheckBoxFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JCheckBox hJCheckBox;
	private JCheckBox sJCheckBox;
	private JMenuBar bar;
	private JMenuItem item;
	private JMenu menu;
	public CheckBoxFrame ()
	{
		super ("JCheckBox Text");
		setLayout(new FlowLayout());
		
		textField = new JTextField("",20);
		textField.setFont(new Font("Serif",Font.PLAIN,14));
		add(textField);
		
		hJCheckBox = new JCheckBox("hello");
		sJCheckBox =  new JCheckBox("SUSTC");
		add(hJCheckBox);
		add(sJCheckBox);
		
		bar = new JMenuBar();
		setJMenuBar(bar);
		
		
		menu = new JMenu("菜单");
		bar.add(menu);
		
		//item = new JMenu
		//add(bar);
		
		CheckBoxHandler handler= new CheckBoxHandler();
		hJCheckBox.addItemListener(handler);
		sJCheckBox.addItemListener( handler);
	}
	
	private class CheckBoxHandler implements ItemListener
	{
		public void itemStateChanged(ItemEvent event)
		{
			if(hJCheckBox.isSelected()&&sJCheckBox.isSelected())
				textField.setText("hello SUSTC");
			else if(hJCheckBox.isSelected())
				textField.setText("hello");
			else if(sJCheckBox.isSelected())
				textField.setText("SUSTC");
			else 
				textField.setText("");
			
				
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckBoxFrame checkBoxFrame  = new CheckBoxFrame();
		checkBoxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		checkBoxFrame.setSize(275,200);
		checkBoxFrame.setVisible(true);
		checkBoxFrame.setResizable(false);
	}
	public JMenuItem getItem() {
		return item;
	}
	public void setItem(JMenuItem item) {
		this.item = item;
	}

}
