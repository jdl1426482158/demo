package key;

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
		Jb=new JLabel("����");
		this.add(Jb);	
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		
        switch (keyCode) {//�жϼ���ֵ
		
		case 37:
			Jb.setText("��");
			System.out.println("��");
			break;// ��
		case 38:
			Jb.setText("��");
			System.out.println("��");
			break;// ��
		case 39:
			Jb.setText("��");
			System.out.println("��");
			break;// ��
		case 40:
			Jb.setText("��");
			System.out.println("��");
			break;// ��
		
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
				jf.requestFocus();//��ȡ���㣬������Ӧ�����¼�
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