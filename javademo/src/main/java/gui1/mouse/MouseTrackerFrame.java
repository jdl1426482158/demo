package gui1.mouse;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseTrackerFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel mousePanel;
	private JLabel statusBar;
	
	public MouseTrackerFrame()
	{
		super("Demonstrating Mouse Events" );
		 
		mousePanel = new JPanel();
		mousePanel.setBackground(Color.WHITE);
		add(mousePanel,BorderLayout.CENTER);
		
		statusBar = new JLabel("Mouse outside JPanel");
		add(statusBar, BorderLayout.SOUTH);
		
		MouseHandler handler = new MouseHandler();
		mousePanel.addMouseListener(handler);
		mousePanel.addMouseMotionListener(handler);
		
	}
	
	private class MouseHandler implements MouseListener,MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent event) {
			// TODO Auto-generated method stub
			statusBar.setText(String.format("Dragged at [%d,%d]",
				     event.getX(),event.getY() ) );
		}

		@Override
		public void mouseMoved(MouseEvent event) {
			// TODO Auto-generated method stub
			statusBar.setText(String.format("Moved at [%d,%d]",
				     event.getX(),event.getY() ) );
		}

		@Override
		public void mouseClicked(MouseEvent event) {
			// TODO Auto-generated method stub
			statusBar.setText(String.format("Clicked at [%d,%d]",
				     event.getX(),event.getY() ) );
			
		}

		@Override
		public void mouseEntered(MouseEvent event) {
			// TODO Auto-generated method stub
			statusBar.setText(String.format("Entered at [%d,%d]",
				     event.getX(),event.getY() ) );
			mousePanel.setBackground(Color.BLUE);
			
		}

		@Override
		public void mouseExited(MouseEvent event) {
			// TODO Auto-generated method stub
			statusBar.setText("Mouse outside JPanel");
			mousePanel.setBackground(Color.WHITE);
			
		}

		@Override
		public void mousePressed(MouseEvent event) {
			// TODO Auto-generated method stub
			statusBar.setText(String.format("Pressed at [%d,%d]",
				     event.getX(),event.getY() ) );
			
		}

		@Override
		public void mouseReleased(MouseEvent event) {
			// TODO Auto-generated method stub
			statusBar.setText(String.format("Released at [%d,%d]",
				     event.getX(),event.getY() ) );
			mousePanel.setBackground(Color.RED);
			
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MouseTrackerFrame mouseTrackerFrame = new MouseTrackerFrame();
		mouseTrackerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mouseTrackerFrame.setSize(300, 100);
		mouseTrackerFrame.setVisible(true);
	}

}
