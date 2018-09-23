package inClass;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.Rectangle;

import javax.swing.JPanel;
public class PaintPanel extends JPanel{
	private Shape currentShape;
	private Color currentColor;
	private static final Rectangle rect=new Rectangle(0,0,100,100);
	
	public PaintPanel()
	{
		currentShape=(Shape)new Rectangle(0,0,100,100);
	}
	public void paintComponent(Graphics g)
	{
		g.drawRect(rect.x,rect.y,rect.width,rect.height);
	}
}
