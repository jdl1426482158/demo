package clipboard;

/*
* �鿴ͼ�εĴ���
*/
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
*  ������ʾͼ�εĴ���
*/
public class ImageViewer extends Frame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image image;
    /**
    * ��ʾһ��ͼ��
    * @param viewMe
    */
    public ImageViewer(Image viewMe) {
    image = viewMe;
    MediaTracker mediaTracker = new MediaTracker(this);
    mediaTracker.addImage(image, 0);
    try {
    mediaTracker.waitForID(0);
    } catch (InterruptedException ie) {
    ie.printStackTrace();
    System.exit(1);
    }
    addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent e) {
    System.exit(0);
    }
    });
    //������Ӧͼ���С
    setSize(image.getWidth(null), image.getHeight(null));
    //���ڱ���
    setTitle("Viewing Image from Clipboard"); 
    setVisible(true);
    }
    public void paint(Graphics graphics) {
    graphics.drawImage(image, 0, 0, null);
    }
    /**
    * ���ڶ�ȡͼ���ļ�������Image����
    */
    public static Image getImageFromFile(String fileName) {
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Image image = toolkit.getImage(fileName);
    return image;
    }
}