package gui2.fail;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RepairPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel blankLabel;
	private JButton showButton;
	private JLabel nameLabel;
	private JLabel leftBlankLabel;
	private JLabel rightBlankLabel;
	
	public RepairPanel(String name, String path){
		
		blankLabel = new JLabel();
		blankLabel.setText("<html><body>    <br />   <br />  </body></html>");
		
		ImageIcon image = new ImageIcon(path);
		showButton = new JButton();
		showButton.setIcon(image);
		//是按钮只有文字
		showButton.setContentAreaFilled(false);
		nameLabel = new JLabel("       " + name);
		
		leftBlankLabel = new JLabel("    ");
		rightBlankLabel = new JLabel("    ");
		
		setLayout(new BorderLayout());
		add(blankLabel,BorderLayout.NORTH);
		add(showButton,BorderLayout.CENTER);
		add(nameLabel,BorderLayout.SOUTH);
		add(leftBlankLabel,BorderLayout.WEST);
		add(rightBlankLabel,BorderLayout.EAST);
		setOpaque(false);//设置透明
	}

}
