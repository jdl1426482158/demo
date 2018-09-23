package simple;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetToolkit {
	public static void main(String args[]) throws UnknownHostException {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension = toolkit.getScreenSize();
		InetAddress address = InetAddress.getLocalHost();  
		String osUser=System.getProperty("user.name");  
		System.out.println(dimension.width+"  "+dimension.height+"   \n"+address.getHostAddress());
	}
}
