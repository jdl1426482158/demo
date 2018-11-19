package basic.reflect;

import java.lang.reflect.Field;

import sun.misc.Contended;
import sun.misc.Unsafe;

@SuppressWarnings("restriction")
public class TypeSequence {

	@Contended
	private boolean contended_boolean;

	private volatile byte a;
	private volatile boolean b;

	@Contended
	private int contended_short;

	private volatile char d;
	private volatile short c;

	private volatile int e;
	private volatile float f;

	@Contended
	private int contended_int;

	@Contended
	private double contended_double;

	private volatile double g;
	private volatile long h;

	public static Unsafe UNSAFE;

	static {
		try {
			@SuppressWarnings("all")
			Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
			theUnsafe.setAccessible(true);
			UNSAFE = (Unsafe) theUnsafe.get(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isContended_boolean() {
		return contended_boolean;
	}

	public void setContended_boolean(boolean contended_boolean) {
		this.contended_boolean = contended_boolean;
	}

	public byte getA() {
		return a;
	}

	public void setA(byte a) {
		this.a = a;
	}

	public boolean isB() {
		return b;
	}

	public void setB(boolean b) {
		this.b = b;
	}

	public int getContended_short() {
		return contended_short;
	}

	public void setContended_short(int contended_short) {
		this.contended_short = contended_short;
	}

	public char getD() {
		return d;
	}

	public void setD(char d) {
		this.d = d;
	}

	public short getC() {
		return c;
	}

	public void setC(short c) {
		this.c = c;
	}

	public int getE() {
		return e;
	}

	public void setE(int e) {
		this.e = e;
	}

	public float getF() {
		return f;
	}

	public void setF(float f) {
		this.f = f;
	}

	public int getContended_int() {
		return contended_int;
	}

	public void setContended_int(int contended_int) {
		this.contended_int = contended_int;
	}

	public double getContended_double() {
		return contended_double;
	}

	public void setContended_double(double contended_double) {
		this.contended_double = contended_double;
	}

	public double getG() {
		return g;
	}

	public void setG(double g) {
		this.g = g;
	}

	public long getH() {
		return h;
	}

	public void setH(long h) {
		this.h = h;
	}

	public static Unsafe getUNSAFE() {
		return UNSAFE;
	}

	public static void setUNSAFE(Unsafe uNSAFE) {
		UNSAFE = uNSAFE;
	}

	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		System.out.println("e:int    \t" + UNSAFE.objectFieldOffset(TypeSequence.class.getDeclaredField("e")));
		System.out.println("g:double \t" + UNSAFE.objectFieldOffset(TypeSequence.class.getDeclaredField("g")));
		System.out.println("h:long   \t" + UNSAFE.objectFieldOffset(TypeSequence.class.getDeclaredField("h")));
		System.out.println("f:float  \t" + UNSAFE.objectFieldOffset(TypeSequence.class.getDeclaredField("f")));
		System.out.println("c:short  \t" + UNSAFE.objectFieldOffset(TypeSequence.class.getDeclaredField("c")));
		System.out.println("d:char   \t" + UNSAFE.objectFieldOffset(TypeSequence.class.getDeclaredField("d")));
		System.out.println("a:byte   \t" + UNSAFE.objectFieldOffset(TypeSequence.class.getDeclaredField("a")));
		System.out.println("b:boolean\t" + UNSAFE.objectFieldOffset(TypeSequence.class.getDeclaredField("b")));

		System.out.println("contended_boolean:boolean\t"
				+ UNSAFE.objectFieldOffset(TypeSequence.class.getDeclaredField("contended_boolean")));
		System.out.println("contended_short:short\t"
				+ UNSAFE.objectFieldOffset(TypeSequence.class.getDeclaredField("contended_short")));
		System.out.println(
				"contended_int:int\t" + UNSAFE.objectFieldOffset(TypeSequence.class.getDeclaredField("contended_int")));
		System.out.println("contended_double:double\t"
				+ UNSAFE.objectFieldOffset(TypeSequence.class.getDeclaredField("contended_double")));
	}

}
