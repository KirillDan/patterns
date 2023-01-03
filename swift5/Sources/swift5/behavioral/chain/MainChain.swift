fileprivate protocol Element {
	func operation(_ i: Int) -> Void;
}

fileprivate class LastElement : Element {
	func operation(_ i: Int) -> Void {
		print("last " + String(i) + " operation");
	}
}

fileprivate class IterElement : Element {
	private let element: Element;
	
	public init(_ element: Element) {
		self.element = element;
	}

	public func operation(_ i: Int) -> Void {
		print(String(i) + " operation");
		self.element.operation(i + 1);
	}
}

public class ChainMain {
	public static func main() {
		let lastElement: Element = LastElement();
		let iterElement2: Element = IterElement(lastElement);
		let iterElement1: Element = IterElement(iterElement2);
		iterElement1.operation(1);
	}
}