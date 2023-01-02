package structural.decorator;

interface Component {
	public String operation();
}

class ConcreteComponent implements Component {
	public String operation() {
		return "concrete operation";
	}
}

abstract class Decorator implements Component {
	protected Component component;
}

class ConcreteDecorator1 extends Decorator {
	public ConcreteDecorator1(Component component) {
		this.component = component;
	}

	@Override
	public String operation() {
		return this.getClass().getSimpleName() + this.component.operation();
	}
}

class ConcreteDecorator2 extends Decorator {
	public ConcreteDecorator2(Component component) {
		this.component = component;
	}

	@Override
	public String operation() {
		return this.getClass().getSimpleName() + this.component.operation();
	}
}


public class DecoratorMain {
	public static void main(String[] args) {
		Component component = new ConcreteComponent();
		ConcreteDecorator1 concreteDecorator1 = new ConcreteDecorator1(component);
		ConcreteDecorator2 concreteDecorator2 = new ConcreteDecorator2(component);
		System.out.println(concreteDecorator1.operation());
		System.out.println(concreteDecorator2.operation());
	}
}
