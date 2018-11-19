package gui1.inClass;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;

import javax.swing.JPanel;

public class PaintPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4690213754539453314L;
	private Shape currentShape;
	private static final Rectangle rect = new Rectangle(0, 0, 100, 100);

	public PaintPanel() {
		setCurrentShape((Shape) new Rectangle(0, 0, 100, 100));
	}
	
	

	public void paintComponent(Graphics g) {
		g.drawRect(rect.x, rect.y, rect.width, rect.height);
	}



	public Shape getCurrentShape() {
		return currentShape;
	}

	public void setCurrentShape(Shape currentShape) {
		this.currentShape = currentShape;
	}
}
