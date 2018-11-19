package gui1.mouse;

import java.awt.Graphics;
import javax.swing.JPanel;

public class PaintJPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g)
	{
		g.fillRect(0,0, 400, 300);
	}

}
