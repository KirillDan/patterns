package behavioral.templateMethod;

abstract class StringCalc {
	public Integer toInteger(String value) {
		return Integer.valueOf(value);
	}
	
	abstract public Integer add(String a, String b);
}

class StringCalcImpl extends StringCalc {

	@Override
	public Integer add(String a, String b) {
		return this.toInteger(a) + this.toInteger(b);
	}
	
}

public class TemplateMethod {
	public static void main(String[] args) {
		StringCalc stringCalc = new StringCalcImpl();
		System.out.println(stringCalc.add("1", "10"));
	}
}
