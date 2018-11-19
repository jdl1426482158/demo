package basic.base;

//����ö�ٶ��ڳ�������ʹ�������ڲ�����ʵ��
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
	 * ���󷽷����ɲ�ͬ��ö��ֵ�ṩ��ͬ��ʵ�֡�
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public abstract double eval(double x, double y);
}
