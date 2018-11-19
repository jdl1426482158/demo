package gui1.shortcut;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Test extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5203253395787509470L;
	private JFileChooser chooser;
	private File file;
	private JTextArea text;
	private int length=0;

	protected Test() throws Exception {

		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		SwingUtilities.updateComponentTreeUI(this);

		chooser = new JFileChooser();
		text = new JTextArea();
		
		text.getDocument().addDocumentListener(new DocumentListener(){

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				System.out.println("insert");
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				
				System.out.println("remove");
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				System.out.println("changed");
			}
			
		});
		// text.setEditable(false);
		
		add(text);

		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("file(F)");
		menu.setMnemonic('F');
		JMenuItem item = new JMenuItem("open file(o)");
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				chooser.showDialog(null, "open file");
				file = chooser.getSelectedFile();
				if (file != null)
					text.setText(file.getAbsolutePath());
			}
		};
		item.addActionListener(action);
		item.setMnemonic('o');
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		menu.add(item);
		bar.add(menu);
		setJMenuBar(bar);

		// setVisible(true);
	}

	public static void main(String args[]) throws Exception {
		new Test().setVisible(true);
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}
