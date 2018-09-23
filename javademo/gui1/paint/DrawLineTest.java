package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class DrawLineTest extends JPanel {

	private int startx, starty;
	private int midx, midy;
	// private boolean sit=false;//false表示上一个保存在midx[0],midy[0];
	private int endx, endy;

	private Shape shape;
	private Rectangle rect;
	
	public DrawLineTest() {
		Handler handler = new Handler();
		addMouseListener(handler);
		addMouseMotionListener(handler);

		rect = new Rectangle(0,0,100,100);
	}

	private class Handler implements MouseListener, MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			midx = endx;
			midy = endy;
			endx = arg0.getX();
			endy = arg0.getY();
			repaint();// 只有放在最后才能产生最少歧义
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			startx = arg0.getX();
			starty = arg0.getY();
			midx = startx;
			midy = starty;
			endx = startx;
			endy = starty;// 对坐标初始化
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}
	}

	public void paint(Graphics g) {

		g.setColor(Color.WHITE);
		g.drawLine(startx, starty, midx, midy);

		g.setColor(Color.GREEN);
		g.drawLine(startx, starty, endx, endy);

		g.copyArea(0, 0, 100, 100, 100, 100);

	}
	
}
