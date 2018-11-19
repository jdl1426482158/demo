package multithread.i_GUI;

import java.util.concurrent.ExecutionException;

import javax.swing.JLabel;
import javax.swing.SwingWorker;

public class BackgroundCalculator extends SwingWorker<Long,Object>{

	private final int n;
	private final JLabel resultJLabel;
	
	public BackgroundCalculator(int number, JLabel label )
	{
		n = number;
		resultJLabel = label;
	}
	
	public Long doInBackground()
	{
		long nthFib = fibonacci( n );
		return nthFib;                                   ///return String.valueOf( nthFib );            //////////////
	}
	
	protected void done()
	{
		try
		{
			resultJLabel.setText(get().toString());
		}
		catch(InterruptedException ex)
		{
			resultJLabel.setText("Interrupted while waiting for results.");
		}
		catch(ExecutionException ex)
		{
			resultJLabel.setText(
					"Error encountered while performing calculation.");
		}
	}
	
	public long fibonacci(long number)
	{
		if(number == 0 || number == 1)
			return number;
		else
			return fibonacci(number - 1 )+fibonacci(number - 2);
	}

}
