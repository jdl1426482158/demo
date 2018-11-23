package gui2.fail;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class JFrameDemo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int width = 900;
	private final int height = 600;

	private StartUpPanel startPanel;
	private FunctionPanel functionpanel;

	public JFrameDemo() {

		getContentPane();
		startPanel = new StartUpPanel();
		functionpanel = new FunctionPanel();
		initialize();
		addContent();
		
		setVisible(true);
	}

	private void initialize() {
		// setBounds(DefaultConstant.DisplayWidth / 2 - width / 2,
		// DefaultConstant.DisplayHeight / 2 - height / 2 - 30, width,
		// height);
		setSize(width, height);//上述的简化版
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 去掉边框
		setUndecorated(true);
	}

	private void addContent() {
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.add(startPanel);
		panel.add(functionpanel);
		add(panel);
		
		
	}

	private void resetLocation(int x, int y) {
		setLocation(x, y);
	}

	private class StartUpPanel extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private final JLabel iconLabel;
		private final JLabel titleLabel;
		private final JButton updateButton;

		public final JButton sharedButton;
		public final JButton skinButton;
		public final JButton suggestionButton;
		public final JButton optionButton;
		public final JButton minimizeButton;
		public final JButton closeButton;

		public StartUpPanel() {

			ImageIcon icon = new ImageIcon("360logo.gif");
			iconLabel = new JLabel(icon);
			titleLabel = new JLabel(" 360安全卫士领航版 ");
			titleLabel.setForeground(Color.WHITE);
			updateButton = new JButton("0");
			updateButton.setForeground(Color.WHITE);
			updateButton.setContentAreaFilled(false);
			
			JPanel titlePanel = new JPanel();
			titlePanel.setLayout(new FlowLayout(1, 0, 0));
			titlePanel.setOpaque(false);
			titlePanel.add(iconLabel);
			titlePanel.add(titleLabel);
			titlePanel.add(updateButton);
			
			JPanel panel1 = new JPanel();
			panel1.setLayout(new FlowLayout(1, 6, 0));
			panel1.setOpaque(false);
			panel1.add(titlePanel);

			
			sharedButton = new JButton("1");
			sharedButton.setForeground(Color.WHITE);
			sharedButton.setContentAreaFilled(false);
			skinButton = new JButton("2");
			skinButton.setForeground(Color.WHITE);
			skinButton.setContentAreaFilled(false);
			suggestionButton = new JButton("3");
			suggestionButton.setForeground(Color.WHITE);
			suggestionButton.setContentAreaFilled(false);
			optionButton = new JButton("4");
			optionButton.setForeground(Color.WHITE);
			optionButton.setContentAreaFilled(false);
			minimizeButton = new JButton("_");
			minimizeButton.setForeground(Color.WHITE);
			minimizeButton.setContentAreaFilled(false);
			minimizeButton.addMouseListener(new MouseAdapter() {
				boolean mouseState = false;
				@Override
				public void mouseReleased(MouseEvent e) {
					if (mouseState)
						setExtendedState(ICONIFIED);
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					mouseState = true;
				}
				@Override
				public void mouseExited(MouseEvent e) {
					mouseState = false;
				}
			});
			closeButton = new JButton("x");
			closeButton.setForeground(Color.WHITE);
			closeButton.setContentAreaFilled(false);
			closeButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			JPanel setPanel = new JPanel();
			setPanel.setLayout(new FlowLayout(1, 0, 0));
			setPanel.add(sharedButton);
			setPanel.add(skinButton);
			setPanel.add(suggestionButton);
			setPanel.add(optionButton);
			setPanel.add(minimizeButton);
			setPanel.add(closeButton);
			setPanel.setOpaque(false);
			
			JPanel panel2 = new JPanel();
			panel2.setLayout(new FlowLayout(1, 6, 0));
			panel2.setOpaque(false);
			panel2.add(setPanel);

			Handler handler = new Handler();
			addMouseListener(handler);
			addMouseMotionListener(handler);

			setLayout(new BorderLayout());
			add(panel1, BorderLayout.WEST);
			add(panel2, BorderLayout.EAST);
			setBounds(0, 0, 900, 440);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			ImageIcon image = new ImageIcon("Frame.jpg");
			g.drawImage(image.getImage(), 0, 0, 900, 440, null);
		}

		public class Handler extends MouseAdapter {

			private int x, y;

			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}

			public void mouseDragged(MouseEvent e) {
				resetLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
			}

		}
	}

	private class FunctionPanel extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public FunctionPanel() {
			
			RepairPanel p = new RepairPanel("修复", "Thunder.png");
			JPanel leftPanel = new JPanel();
			leftPanel.add(p);
			leftPanel.setOpaque(false);

			RepairPanel p1 = new RepairPanel("SISISI", "up.png");
			JPanel rightPanel = new JPanel();
			rightPanel.add(p1);
			rightPanel.setOpaque(false);

			setLayout(new BorderLayout());
			add(leftPanel,BorderLayout.WEST);
			add(rightPanel,BorderLayout.EAST);
			setBackground(Color.PINK);
			setBounds(0, 440, 900,159 );
		}
	}

	public static void main(String[] args) {
		new JFrameDemo();
	}

}
