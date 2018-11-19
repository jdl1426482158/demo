package gui1.twoD;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.stream.FileImageInputStream;
import javax.swing.*;

public class BackGoundTest extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public BackGoundPanel panel;
	
	public BackGoundTest() throws FileNotFoundException, IOException {

		panel = new BackGoundPanel("Lighthouse.jpg");

		panel.setLayout(null);// 为了使用按钮的定位
		JButton button = new JButton("OK");
		button.setSize(100, 20);
		button.setLocation(100, 50);
		button.addActionListener(
				new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						panel.repaint();
					}
					
				}
				);
		panel.add(button);
		add(panel);
		

	}

//自定义一个背景面板的类	
	class BackGoundPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		Image im;//背景图片

		//重载构造方法
		public BackGoundPanel(String IMname) throws FileNotFoundException, IOException {
			File file=new File(IMname);
			FileImageInputStream input=new FileImageInputStream(file);
			input.close();////////////////////////////////////////////////////////////////
			//im = Toolkit.getDefaultToolkit().getImage(
				//	getClass().getResource(IMname));//在创建一个新的背景面板是传入的图片
		}
		//重写paintcomponent方法
		public void paintComponent(Graphics g) {
			g.drawRect(10, 10, 10, 10);
			g.drawImage(im, 0, 0, null);
		}
		
	}

	//主方法
	public static void main(String arg[]) throws FileNotFoundException, IOException {
		BackGoundTest sf = new BackGoundTest();
		sf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sf.setSize(1000, 700);
		
		//sf.pack();//使窗口按其首选大小布局组件（不清楚对背景图意义何在，但一定要有）
		sf.setVisible(true);
	}
}
