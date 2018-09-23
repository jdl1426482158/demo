package interactive;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

/*
 * �������ʱ����ܻ����The package org.rosuda.REngine is accessible from more than one module: REngine, RserveEngine��
 * �����ʾ��ֻҪ��libraryʱ�����ƶ���classpath����ͺ�
 * 
 * ����ʵ��R��install.package(Rserve),����rjava�оͰ�������Ӧ��jar
 */

/*
 * ������Ҫ���û�������
 * D:\studysoft\R-3.4.2\library\Rserve\libs\x64
 */
public class RDemo {
	public static void main(String[] args) throws RserveException, REXPMismatchException {
		RConnection c = new RConnection();
		REXP x = c.eval("R.version.string");
		System.out.println(x.asString());
	}
}
