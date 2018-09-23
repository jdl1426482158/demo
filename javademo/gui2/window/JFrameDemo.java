package window;

import java.awt.AWTEvent;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import constant.DefaultConstant;


public class JFrameDemo extends JFrame {

	private final int width = 900;
	private final int height = 600;

	private Container container;
	private StartUpPanel startPanel;

	public JFrameDemo() {

		container = getContentPane();
		startPanel = new StartUpPanel();
		initialize();
		addContent();
		
		addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				System.out.println("focus");
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				requestFocus();
			}
			
		});
		
		addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				requestFocus();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		setVisible(true);
	}

	

	private void initialize() {
		setBounds(DefaultConstant.DisplayWidth / 2 - width / 2, DefaultConstant.DisplayHeight / 2 - height / 2 - 30,
				width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// »•µÙ±ﬂøÚ
		//setUndecorated(true);
	}

	private void addContent() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout());
		panel.add(startPanel);
		add(panel);
	}

	private class StartUpPanel extends JPanel {

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
			titleLabel = new JLabel("360∞≤»´Œ¿ ø¡Ï∫Ω∞Ê");
			updateButton = new JButton("0");
			JPanel titlePanel = new JPanel();
			titlePanel.setLayout(new FlowLayout());
			titlePanel.add(iconLabel);
			titlePanel.add(titleLabel);
			titlePanel.add(updateButton);

			sharedButton = new JButton("1");
			skinButton = new JButton("2");
			suggestionButton = new JButton("3");
			optionButton = new JButton("4");
			minimizeButton = new JButton("5");
			closeButton = new JButton("6");
			JPanel setPanel = new JPanel();
			setPanel.setLayout(new FlowLayout());
			setPanel.add(sharedButton);
			setPanel.add(skinButton);
			setPanel.add(suggestionButton);
			setPanel.add(optionButton);
			setPanel.add(minimizeButton);
			setPanel.add(closeButton);

			add(titlePanel);
			add(setPanel);
		}

	}

	protected void paintComponent(Graphics g) {
		super.paintComponents(g);
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("Frame.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Frame.jpgÕº∆¨∂¡»° ß∞‹");
			e.printStackTrace();
			System.exit(1);
		}
		g.drawImage(image, 0, 0, null);
	}

	public static void main(String[] args) {
		new JFrameDemo();
	}

}
