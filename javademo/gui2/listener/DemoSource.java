package listener;

import java.util.Vector;
import java.util.Enumeration;

public class DemoSource {     
    private Vector<DemoListener> repository = new Vector<DemoListener>();//�����Լ��ļ���������     
    public DemoSource(){}     
    public void addDemoListener(DemoListener dl) {     
           repository.addElement(dl);     
    }     
    public void notifyDemoEvent() {//֪ͨ���еļ�����     
    	Enumeration<DemoListener> enum1 = repository.elements();     
           while(enum1.hasMoreElements()) {     
                   DemoListener dl = (DemoListener)enum1.nextElement();     
                 dl.handleEvent(new DemoEvent(this));     
           }     
    }     
}    