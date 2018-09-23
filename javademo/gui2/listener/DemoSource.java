package listener;

import java.util.Vector;
import java.util.Enumeration;

public class DemoSource {     
    private Vector<DemoListener> repository = new Vector<DemoListener>();//监听自己的监听器队列     
    public DemoSource(){}     
    public void addDemoListener(DemoListener dl) {     
           repository.addElement(dl);     
    }     
    public void notifyDemoEvent() {//通知所有的监听器     
    	Enumeration<DemoListener> enum1 = repository.elements();     
           while(enum1.hasMoreElements()) {     
                   DemoListener dl = (DemoListener)enum1.nextElement();     
                 dl.handleEvent(new DemoEvent(this));     
           }     
    }     
}    