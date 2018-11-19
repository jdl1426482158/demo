package gui1.GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class DrawLineTest extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1581563146776969333L;
	private int startx=0,starty=0;
	private int midx=0,midy=0;
	private int endx=0,endy=0;
	private int counter=0;
	
	public DrawLineTest() {
		Handler handler = new Handler();
		addMouseListener(handler);
		addMouseMotionListener(handler);
	}
	
	private class Handler implements MouseListener,MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			endx=arg0.getX();
			endy=arg0.getY();
			counter++;
			repaint();
			//不管repaint()放在mouseDragged的哪个位置，他总是在最后才执行
			counter++;
			
			midx=endx;
			midy=endy;
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
			
			startx=arg0.getX();
			starty=arg0.getY();
			midx=startx;
			midy=starty;
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}
	}
	public void paint(Graphics g) {
		
		System.out.println(counter);
		g.setColor(Color.WHITE);
		g.drawLine(startx,starty,midx,midy);

		g.setColor(Color.GREEN);
		g.drawLine(startx, starty,endx, endy);
		

	}
}
