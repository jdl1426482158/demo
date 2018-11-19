package basic.base;

//抽象枚举对于常量必须使用匿名内部类来实现
public enum EnumExample_Operation {
	PLUS {

		@Override
		public double eval(double x, double y) {
			return x + y;
		}

	},
	MINUS {

		@Override
		public double eval(double x, double y) {
			return x - y;
		}

	},
	TIMES {

		@Override
		public double eval(double x, double y) {
			return x * y;
		}

	},
	DIVIDE {

		@Override
		public double eval(double x, double y) {
			return x / y;
		}

	};

	/**
	 * 抽象方法，由不同的枚举值提供不同的实现。
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public abstract double eval(double x, double y);
}
