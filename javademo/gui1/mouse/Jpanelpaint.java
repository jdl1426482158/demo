package mouse;

/*这个程序设计目的是用鼠标拖动图形
 *其中有一条语句出问题了，用//去掉了，后面注明了问题语句
 * 没那条语句时程序正常运行，即鼠标拖动n次后，mouseDragged总共被执行n次，
 *
 * 有了那条语句后，鼠标拖动一次，mouseDragged总共被执行2^n-1，
 * 这是什么原因啊，代码改改成怎么样啊
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
	private int ypoint;//上一次的鼠标指针的坐标
	
	
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
			
	        switch (keyCode) {//判断键盘值
			
			case 37:
				x-=3;
				break;// 左
			case 38:
				y-=3;
				break;// 上
			case 39:
				x+=3;
				break;// 右
			case 40:
				y+=3;
				break;// 下
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
			    //Jpanelpaint.this.paintComponent(g);    用来鼠标拖动发生后重新绘制图像                   问题语句
			}
		}
		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			Jpanelpaint.this.requestFocus();//是面板聚焦键盘事件
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
			xpoint=e.getX();
			ypoint=e.getY();
			hasClicked=true;
			isInRect=xpoint>=x&&xpoint<=x+width&&ypoint>=y&&ypoint<=y+height;
			//判断鼠标是否落在了图形内
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
