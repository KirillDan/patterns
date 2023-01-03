package behavioral.templateMethod;

abstract class Conversion {
	public Float toCM(Integer inch) {
		return new Float(inch) * 2.54f;
	}
	
	abstract public Float addCmAndInch(Integer cm, Integer inch);
}

class AddingImpl extends Conversion {

	@Override
	public Float addCmAndInch(Integer cm, Integer inch) {
		return cm + this.toCM(inch);
	}
	
}

public class TemplateMethod {
	public static void main(String[] args) {
		AddingImpl addingImpl = new AddingImpl();
		Integer cm = 1;
		Integer inch = 1;
		System.out.println(cm + " cm + " + inch + " inch = " + addingImpl.addCmAndInch(cm, inch) + " cm");
	}
}
