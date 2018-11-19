package gui2.listener;

public class TestDemo {     
	   DemoSource ds;     
	   public TestDemo(){     
	      try{     
	         ds = new DemoSource();     
	         //�����������¼�Դ�����еǼǣ�     
	         DemoListener1 listener1 = new DemoListener1();     
	         ds.addDemoListener(listener1);     
	         ds.addDemoListener(new DemoListener() {     
	            public void handleEvent(DemoEvent event) {     
	            System.out.println("Method come from ������...");     
	          }     
	        });     
	       ds.notifyDemoEvent();//�����¼���֪ͨ������     
	     }catch(Exception ex){  
	       ex.printStackTrace();  
	       }     
	    }     
	    
	    public static void main(String args[]) {     
	           new TestDemo();     
	    }     
	} 
