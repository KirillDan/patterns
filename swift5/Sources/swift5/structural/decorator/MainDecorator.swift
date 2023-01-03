
fileprivate protocol Component {
    func operation() -> String
}

fileprivate class ConcreteComponent : Component {
    func operation() -> String {
        return "concrete operation"
    }
}

fileprivate class Decorator : Component {
    var component: Component
    init(_ component: Component) {
        self.component = component
    }
    func operation() -> String {
        fatalError()
    }
}

fileprivate class ConcreteDecorator1 : Decorator {
    override func operation() -> String {
        return "ConcreteDecorator1 " + component.operation()
    }
}

fileprivate class ConcreteDecorator2 : Decorator {
    override func operation() -> String {
        return "ConcreteDecorator2 " + component.operation()
    }
}

public class DecoratorMain {
    public static func main() {
        let component: Component = ConcreteComponent()
        let concreteDecorator1 = ConcreteDecorator1(component)
        let concreteDecorator2 = ConcreteDecorator2(component)
        print(concreteDecorator1.operation())
        print(concreteDecorator2.operation())
    }
}