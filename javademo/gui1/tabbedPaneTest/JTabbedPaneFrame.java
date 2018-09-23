package tabbedPaneTest;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JTabbedPaneFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JLabel label;
	MyJPanel panel;
	
	public JTabbedPaneFrame()
	{
		super("JTabbedPane Demo ");
		
		JTabbedPane tabbedPane =new JTabbedPane();
		
		panel=new MyJPanel();
		tabbedPane.addTab("Tab one",null,panel,"First Panel");
		
		label = new JLabel(panel.getText(),SwingConstants.CENTER);
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.YELLOW);
		panel1.add(label);
		tabbedPane.addTab("Tab Two", null,panel1,"Second Panel");
		
		add(tabbedPane);
		
		tabbedPane.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				label.setText(panel.getText());
			}
		});
	}
}
