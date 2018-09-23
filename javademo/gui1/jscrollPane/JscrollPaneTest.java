package jscrollPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class JscrollPaneTest extends JFrame{

	public JscrollPaneTest()
	{
		JScrollPane scrollPane=new JScrollPane();
		JTextArea area=new JTextArea();
		area.setEditable(false);
		area.setText("hello");
		scrollPane.getViewport().add(area);

		add(scrollPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		new JscrollPaneTest();
		
	}

}
