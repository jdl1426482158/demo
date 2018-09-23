package mouse;

/*����������Ŀ����������϶�ͼ��
 *������һ�����������ˣ���//ȥ���ˣ�����ע�����������
 * û�������ʱ�����������У�������϶�n�κ�mouseDragged�ܹ���ִ��n�Σ�
 *
 * ����������������϶�һ�Σ�mouseDragged�ܹ���ִ��2^n-1��
 * ����ʲôԭ�򰡣�����ĸĳ���ô����
 * 
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class Jpanelpaint extends JPanel{
	private static final long serialVersionUID = 1L;
	private static int x=10,y=10,width=100, height=100;
	private boolean hasClicked=false;
	private boolean isInRect=false;
	private int xpoint;
	private int ypoint;//��һ�ε����ָ�������
	
	
	public Jpanelpaint(){
		MouseHandler mousehandler=new MouseHandler();	
		KeyHandler keyhandler=new KeyHandler();
		addMouseMotionListener(mousehandler);
		addMouseListener(mousehandler);
		addKeyListener(keyhandler);
	}
	
	private class KeyHandler implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			int keyCode = e.getKeyCode();
			
	        switch (keyCode) {//�жϼ���ֵ
			
			case 37:
				x-=3;
				break;// ��
			case 38:
				y-=3;
				break;// ��
			case 39:
				x+=3;
				break;// ��
			case 40:
				y+=3;
				break;// ��
	        }
	        if(x<0)
	        	x=0;
	        if(y<0)
	        	y=0;
	        Graphics g=Jpanelpaint.this.getGraphics();
		    Jpanelpaint.this.paintComponent(g);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
			
		}
		
	}
	
	private class MouseHandler implements MouseMotionListener,MouseListener
	{
		@Override
		public void mouseDragged(MouseEvent e){
			// TODO Auto-generated method stub
			if(isInRect&&hasClicked)
			{
				x+=(e.getX()-xpoint);
				y+=(e.getY()-ypoint);
				xpoint=e.getX();
				ypoint=e.getY();
				
				if(x<0) x=0;
				if(y<0) y=0;
				Graphics g=Jpanelpaint.this.getGraphics();
			    Jpanelpaint.this.paintComponent(g);
			    //Jpanelpaint.this.paintComponent(g);    ��������϶����������»���ͼ��                   �������
			}
		}
		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			Jpanelpaint.this.requestFocus();//�����۽������¼�
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
			xpoint=e.getX();
			ypoint=e.getY();
			hasClicked=true;
			isInRect=xpoint>=x&&xpoint<=x+width&&ypoint>=y&&ypoint<=y+height;
			//�ж�����Ƿ�������ͼ����
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			xpoint=0;
			ypoint=0;
			hasClicked=false;
			isInRect=false;
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			isInRect=true;
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			isInRect=false;
		}
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jf=new JFrame("circle");
		jf.setBounds(100,100,400,300);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Jpanelpaint jp=new Jpanelpaint();
		jf.add(jp,BorderLayout.CENTER);
		
		jf.setVisible(true);
		

	}

}
