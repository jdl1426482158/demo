package interactive;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

/*
 * 导入包的时候可能会出现The package org.rosuda.REngine is accessible from more than one module: REngine, RserveEngine，
 * 这个提示，只要再library时把他移动到classpath里面就好
 * 
 * 包其实再R中install.package(Rserve),后在rjava中就包含了相应的jar
 */

/*
 * 可能需要配置环境变量
 * D:\studysoft\R-3.4.2\library\Rserve\libs\x64
 */
public class RDemo {
	public static void main(String[] args) throws RserveException, REXPMismatchException {
		RConnection c = new RConnection();
		REXP x = c.eval("R.version.string");
		System.out.println(x.asString());
	}
}
