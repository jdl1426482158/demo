package observer;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JWindow;
 
public class NumObserver implements Observer{
    public void update(Observable o, Object arg) {
       NumObservable myObserable=(NumObservable) o;
       System.out.println("Data has changed to " +myObserable.getData());
       JLabel label = new JLabel("hello");
       JWindow window = new JWindow();
       label.getAccessibleContext();
       window.getAccessibleContext();
      
       //ImageIcon image= new ImageIcon();
    }
}
