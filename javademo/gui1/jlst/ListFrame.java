package jlst;

import java.awt.FlowLayout;
import java.awt.Color;

import javax.swing.*;
import javax.swing.event.*;

public class ListFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList<Object> colorJList;
	private static final String[] colorNames = { "Black", "Blue", "Cyan",
			"Dark Gray", "Gray", "Green ", "Light Gray", "Magenta", "Orange",
			"Pink", "Red", "White", "Yellow" };
	private static final Color[] colors = { Color.BLACK, Color.BLUE,
			Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN,
			Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK,
			Color.RED, Color.WHITE, Color.YELLOW };

	private static int i=0;
	public ListFrame()
	{
		super("List Test");
		setLayout(new FlowLayout());
		colorJList =new JList<Object>(colorNames);
		colorJList.setVisibleRowCount(5);
		
		colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		add(new JScrollPane(colorJList));
		
		colorJList.addListSelectionListener(
				new ListSelectionListener(){
					@Override
					public void valueChanged(ListSelectionEvent event)
					{
						getContentPane().setBackground( 
								colors[ colorJList.getSelectedIndex( ) ] );
					}
				
				});
		colorJList.addListSelectionListener(
				new ListSelectionListener(){
					@Override
					public void valueChanged(ListSelectionEvent event)
					{
						i++;
						System.out.println(i);//改变一次会执行两边；
						//ERROR
					}
				
				});
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListFrame listFrame = new ListFrame();
		listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listFrame.setSize(350,150);
		listFrame.setVisible(true);
	}

}
