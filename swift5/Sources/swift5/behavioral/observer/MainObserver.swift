

fileprivate protocol Observer {
	func update(_ data: String) -> Void
	func getId() -> Int
}

fileprivate class ConcreteObserver : Observer {
	private let i: Int = Int.random(in: 1..<Int.max);

	func getId() -> Int {
		return self.i
	}

	func update(_ data: String) -> Void {
		print(data + " " + String(i));
	}
}

fileprivate protocol Subject {
	func attach(observer: any Observer) -> Void;
	func detach(observer: any Observer) -> Void;
	func notifyObservers() -> Void;
}

fileprivate class ConcreteSubject : Subject {
	private var subjectState: String = "";
	private var observers: Array<any Observer> = Array();

	func attach(observer: any Observer) -> Void {
		self.observers.append(observer);
	}

	func detach(observer: any Observer) -> Void {
		self.observers = self.observers.filter{$0.getId() != observer.getId()};
	}
	
	func notifyObservers() -> Void {
		for observer: any Observer in self.observers {
			observer.update(self.subjectState);
		}
	}

	public func getSubjectState() -> String {
		return subjectState;
	}

	public func setSubjectState(_ subjectState: String) -> Void {
		self.subjectState = subjectState;
	}
}

public class ObserverMain {
	public static func main() {
		let observer1 = ConcreteObserver();
		let observer2 = ConcreteObserver();
		let concreteSubject = ConcreteSubject();
		concreteSubject.attach(observer: observer1);
		concreteSubject.attach(observer: observer2);
		concreteSubject.setSubjectState("Hello");
		concreteSubject.notifyObservers();
		concreteSubject.setSubjectState("Message");
		concreteSubject.notifyObservers();
	}
}