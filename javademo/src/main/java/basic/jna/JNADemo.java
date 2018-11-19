package basic.jna;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
 
/** Simple example of native library declaration and usage. */
public class JNADemo {
 
	/*
	 * 这个DLibrary名字是自己定义的
	 */
    public interface DLibrary extends Library {
    	//判断是否为window平台,调用window平台下的msvcrt.dll
    	
    	//通过INSTANCE,这个public static变量来返回实例
        DLibrary INSTANCE = (DLibrary)
            Native.loadLibrary((Platform.isWindows() ? "msvcrt" : "c"),
                               DLibrary.class);
   
        void printf(String format, Object... args);
    }
 
    public static void main(String[] args) {
        DLibrary.INSTANCE.printf("Hello, World\n");
        
        for (int i=0;i < args.length;i++) {
            DLibrary.INSTANCE.printf("Argument %d: %s\n", i, args[i]);
        }
    }
}