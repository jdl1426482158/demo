package basic.io.stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author jdl time: 2018年11月25日 下午9:03:11
 */
public class ObjectUtil {

	/**
	 * 将对象转换为byte数组
	 * author : jdl
	 * @param obj
	 * @return
	 */
	public static <T extends Serializable> byte[] toByte(T obj) {
		// 用来将对象输出到内存中
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		ObjectOutputStream objOut = null;
		try {
			objOut = new ObjectOutputStream(byteOut);
			objOut.writeObject(obj);
			return byteOut.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				objOut.close();
			} catch (IOException e) {
			}
		}

	}

	/**
	 * 将数据转换为对象
	 * author : jdl
	 * @param data
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T toObject(byte[] data) {
		if (data == null || data.length == 0)
			return null;

		ByteArrayInputStream byteIn = new ByteArrayInputStream(data);
		ObjectInputStream objIn = null;
		try {
			objIn = new ObjectInputStream(byteIn);
			return (T) objIn.readObject();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				objIn.close();
			} catch (IOException e) {
			}
		}
	}

}
