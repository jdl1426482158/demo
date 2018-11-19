package gui1.inClass;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;

public class PopupMenuFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -315006599666905948L;
	PaintPanel paintPanel;
	JPopupMenu popupMenu;
	JRadioButtonMenuItem circleButton;
	JRadioButtonMenuItem rectButton;

	public PopupMenuFrame() {
		// paintPanel=new PaintPanel();
		// add(paintPanel);
		setLayout(new BorderLayout());
		popupMenu = new JPopupMenu();
		add(popupMenu);

		JMenu shape = new JMenu("ÐÎ×´");
		JMenu color = new JMenu("ÑÕÉ«");
		popupMenu.add(shape);
		popupMenu.add(color);

		/*
		 * circleButton=new JRadioButtonMenuItem("Ô²"); rectButton=new
		 * JRadioButtonMenuItem("¾ØÐÎ"); shape.add(circleButton); shape.add(rectButton);
		 * 
		 * ItemHandler itemHandler= new ItemHandler();
		 * circleButton.addItemListener(itemHandler);
		 * rectButton.addItemListener(itemHandler);
		 * 
		 * ButtonGroup shapeGroup=new ButtonGroup(); shapeGroup.add(circleButton);
		 * shapeGroup.add(rectButton);
		 */
	}
	/*
	 * class ItemHandler implements ItemListener{
	 * 
	 * @Override public void itemStateChanged(ItemEvent arg0) { // TODO
	 * Auto-generated method stub if(circleButton.isSelected());
	 * paintPanel.repaint(); }
	 * 
	 * }
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PopupMenuFrame frame = new PopupMenuFrame();
		frame.setBounds(0, 0, 200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
