package multithread.j_GUItwo;

/////////The example of application of SwingWorker

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class FindPrimesTest extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JTextField highestPrimeJTextField = new JTextField();
	private final JButton getPrimesJButton = new JButton("Get Primes");
	private final JTextArea displayPrimesJTextArea = new JTextArea();
	private final JButton cancelJButton = new JButton("Cannel");
	private JProgressBar progressJProgressBar = new JProgressBar();
	private JLabel statusJLabel = new JLabel();
	private PrimeCalculator calculator;
	
	//constructor 
	public FindPrimesTest()
	{
		super( "Finding Primes with SwingWorker");
		setLayout(new BorderLayout());
		
		//initialize panel to get a number from the user
		JPanel northJPanel = new JPanel();
		northJPanel.add(new JLabel("Find primes less than: "));
		highestPrimeJTextField.setColumns(5);           //文本框宽度
		northJPanel.add(highestPrimeJTextField);
		getPrimesJButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						progressJProgressBar.setValue(0);
						displayPrimesJTextArea.setText("");
						statusJLabel.setText("");
						
						int number;
						
						try
						{
							
							number = Integer.parseInt(
									highestPrimeJTextField.getText());//**************
						}catch(NumberFormatException ex)
						{
							statusJLabel.setText("Enter an integer.");
							return;
						}
						
						calculator = new PrimeCalculator(number,
								displayPrimesJTextArea,statusJLabel,getPrimesJButton,
								cancelJButton);
						
						calculator.addPropertyChangeListener(
								new PropertyChangeListener()
								{
									public void propertyChange(PropertyChangeEvent e)
									{
									if(e.getPropertyName().equals("progress"))
									{
										int newValue = (Integer)e.getNewValue();
										progressJProgressBar.setValue(newValue);
									}
									}
								}
								);
						
						getPrimesJButton.setEnabled(false);
						cancelJButton.setEnabled(true);
						
						calculator.execute();
					}
				}
		);
		northJPanel.add(getPrimesJButton);
		
		displayPrimesJTextArea.setEditable(false);
		add(new JScrollPane(displayPrimesJTextArea,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
		
		JPanel southJPanel = new JPanel(new GridLayout(1,3,10,10));
		cancelJButton.setEnabled(false);
		cancelJButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						calculator.cancel(true);
					}
				}
				);
		southJPanel.add(cancelJButton);
		progressJProgressBar.setStringPainted(true);
		southJPanel.add(progressJProgressBar);
		southJPanel.add(statusJLabel);
		
		add(northJPanel,BorderLayout.NORTH);
		add(southJPanel,BorderLayout.SOUTH);
		setSize(350,300);
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		FindPrimesTest application = new FindPrimesTest();
		application.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
