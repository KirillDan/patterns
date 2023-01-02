package behavioral.chain;

interface Element {
	public void operation(Integer i);
}

class LastElement implements Element {
	@Override
	public void operation(Integer i) {
		System.out.println("last " + i + " operation");
	}
}

class IterElement implements Element {
	private Element element;
	
	public IterElement(Element element) {
		this.element = element;
	}

	@Override
	public void operation(Integer i) {
		System.out.println(i + " operation");
		this.element.operation(i + 1);
	}
}

public class ChainMain {
	public static void main(String[] args) {
		Element lastElement = new LastElement();
		Element iterElement2 = new IterElement(lastElement);
		Element iterElement1 = new IterElement(iterElement2);
		iterElement1.operation(1);
	}
}
