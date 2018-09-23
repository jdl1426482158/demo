package sliderTest_ImageIO;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JSlider diameterJSlider;
	private OvalPanel myPanel;
	
	public SliderFrame()
	{
		super("Slider Demo");
		
		myPanel = new OvalPanel();
		myPanel.setBackground(Color.YELLOW);
		
		diameterJSlider=new JSlider(SwingConstants.HORIZONTAL);
		diameterJSlider.setMajorTickSpacing(10);
		diameterJSlider.setPaintTicks(true);
		
		diameterJSlider.addChangeListener(
				new ChangeListener()
				{

					@Override
					public void stateChanged(ChangeEvent arg0) {
						// TODO Auto-generated method stub
						myPanel.setDiameter(diameterJSlider.getValue());
					}
				});
		add(diameterJSlider,BorderLayout.SOUTH);
		add(myPanel,BorderLayout.CENTER);
	}
}
