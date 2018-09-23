package sliderTest_ImageIO;

import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.JPanel;

public class OvalPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int diameter=10;
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.fillOval(10, 10, diameter, diameter);
	}

	public void setDiameter(int newDiameter)
	{
		diameter= (newDiameter>=0?newDiameter:10);
		repaint();
	}
	
	public Dimension getPreferredSize()
	{
		return new Dimension(200,200);
	}
	
	public Dimension getMinimum(){
		return getPreferredSize();
	}
}
