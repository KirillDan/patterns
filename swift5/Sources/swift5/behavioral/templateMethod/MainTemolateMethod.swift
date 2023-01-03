
fileprivate protocol Conversion {
	func addCmAndInch(_ cm: Int, _ inch: Int) -> Float;
}

fileprivate extension Conversion {
    public func toCM(_ inch: Int) -> Float {
		return Float(inch) * 2.54;
	}
}

fileprivate class AddingImpl : Conversion {

	public func addCmAndInch(_ cm: Int, _ inch: Int) -> Float {
		return Float(cm) + self.toCM(inch);
	}
	
}

public class TemplateMethod {
	public static func main() {
		let addingImpl = AddingImpl()
		let cm = 1
		let inch = 1
		let result = addingImpl.addCmAndInch(cm, inch)
		print("\(cm) cm + \(inch) inch = \(result) cm")
	}
}
