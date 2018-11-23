package gui1.key;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KeyListenerTestPanel extends JPanel implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7282579727602323973L;
	JLabel Jb;
	public KeyListenerTestPanel(){
		Jb=new JLabel("测试");
		this.add(Jb);	
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		
        switch (keyCode) {//判断键盘值
		
		case 37:
			Jb.setText("左");
			System.out.println("左");
			break;// 左
		case 38:
			Jb.setText("上");
			System.out.println("上");
			break;// 上
		case 39:
			Jb.setText("右");
			System.out.println("右");
			break;// 右
		case 40:
			Jb.setText("下");
			System.out.println("下");
			break;// 下
		
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	public static void main(String args[]){
		
		final JFrame jf = new JFrame();
		jf.setSize(100, 100);
		KeyListenerTestPanel  jp =	new KeyListenerTestPanel();
		jf.add(jp);
		jf.addKeyListener(jp);
		
		JTextField jt=new JTextField("hello");
		jt.setSize(40,60);
		jp.add(jt);
		
		jp.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				jf.requestFocus();//获取焦点，才能响应键盘事件
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		jf.setVisible(true);
		
	}
}