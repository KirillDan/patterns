
fileprivate protocol Command {
	func execute() -> Void
}

class Receiver {
	public func prepateAction() -> Void {
		print("prepare action")
	}
	
	public func finalAction() -> Void  {
		print("final action")
	}
	
	public func action1() -> Void  {
		print("make action1")
	}
	
	public func action2() -> Void  {
		print("make action2")
	}
}

class ConcreteCommand1 : Command {
	private let receiver: Receiver

	public init(_ receiver: Receiver) {
		self.receiver = receiver;
	}

	func execute() -> Void {
		self.receiver.prepateAction()
		self.receiver.action1()
		self.receiver.finalAction()
	}
}

fileprivate class ConcreteCommand2 : Command {
	private let receiver: Receiver

	public init(_ receiver: Receiver) {
		self.receiver = receiver
	}

	func execute() -> Void {
		self.receiver.prepateAction()
		self.receiver.action2()
		self.receiver.finalAction()
	}
}

fileprivate class Invoker {
	private let concreteCommand1: Command
	private let concreteCommand2: Command
	
	public init(_ concreteCommand1: Command, _ concreteCommand2: Command) {
		self.concreteCommand1 = concreteCommand1
		self.concreteCommand2 = concreteCommand2
	}
	
	public func makeAction1() -> Void {
		self.concreteCommand1.execute()
	}
	
	public func makeAction2() -> Void {
		self.concreteCommand2.execute()
	}
}

public class CommandMain {
	public static func main() {
		let receiver = Receiver();
		let concreteCommand1 = ConcreteCommand1(receiver)
		let concreteCommand2 = ConcreteCommand2(receiver)
		let invoker = Invoker(concreteCommand1, concreteCommand2)
		invoker.makeAction1()
		print()
		invoker.makeAction2()
	}
}