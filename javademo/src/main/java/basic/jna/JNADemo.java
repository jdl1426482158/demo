package basic.jna;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
 
/** Simple example of native library declaration and usage. */
public class JNADemo {
 
	/*
	 * ���DLibrary�������Լ������
	 */
    public interface DLibrary extends Library {
    	//�ж��Ƿ�Ϊwindowƽ̨,����windowƽ̨�µ�msvcrt.dll
    	
    	//ͨ��INSTANCE,���public static����������ʵ��
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