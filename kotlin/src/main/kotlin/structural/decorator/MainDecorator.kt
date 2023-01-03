package structural.decorator

internal interface Component {
    fun operation(): String
}

internal class ConcreteComponent : Component {
    override fun operation(): String {
        return "concrete operation"
    }
}

internal abstract class Decorator : Component {
    protected lateinit var component: Component
}

internal class ConcreteDecorator1 : Decorator {
    constructor(component: Component) {
        super.component = component
    }

    override fun operation(): String {
        return "ConcreteDecorator1 " + component.operation()
    }
}

internal class ConcreteDecorator2 : Decorator {
    constructor(component: Component) {
        super.component = component
    }

    override fun operation(): String {
        return "ConcreteDecorator2 " + component.operation()
    }
}

fun main(args: Array<String>) {
    val component: Component = ConcreteComponent()
    val concreteDecorator1 = ConcreteDecorator1(component)
    val concreteDecorator2 = ConcreteDecorator2(component)
    println(concreteDecorator1.operation())
    println(concreteDecorator2.operation())
}
