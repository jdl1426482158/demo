package gui1.sliderTest_ImageIO;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class SliderDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		SliderFrame sliderFrame = new SliderFrame();
		
		sliderFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sliderFrame.setSize(220, 270);
		sliderFrame.setUndecorated(true);//Òþ²Ø±ß¿ò£»
		sliderFrame.setVisible(true);
		
		BufferedImage bi = new BufferedImage(sliderFrame.getWidth(),
				sliderFrame.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = bi.createGraphics();
		sliderFrame.paint(g2d);
		ImageIO.write(bi, "PNG", new File("frame.png"));
		
	}

}
