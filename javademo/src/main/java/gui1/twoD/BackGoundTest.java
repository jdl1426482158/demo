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

		panel.setLayout(null);// Ϊ��ʹ�ð�ť�Ķ�λ
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

//�Զ���һ������������	
	class BackGoundPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		Image im;//����ͼƬ

		//���ع��췽��
		public BackGoundPanel(String IMname) throws FileNotFoundException, IOException {
			File file=new File(IMname);
			FileImageInputStream input=new FileImageInputStream(file);
			input.close();////////////////////////////////////////////////////////////////
			//im = Toolkit.getDefaultToolkit().getImage(
				//	getClass().getResource(IMname));//�ڴ���һ���µı�������Ǵ����ͼƬ
		}
		//��дpaintcomponent����
		public void paintComponent(Graphics g) {
			g.drawRect(10, 10, 10, 10);
			g.drawImage(im, 0, 0, null);
		}
		
	}

	//������
	public static void main(String arg[]) throws FileNotFoundException, IOException {
		BackGoundTest sf = new BackGoundTest();
		sf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sf.setSize(1000, 700);
		
		//sf.pack();//ʹ���ڰ�����ѡ��С���������������Ա���ͼ������ڣ���һ��Ҫ�У�
		sf.setVisible(true);
	}
}
