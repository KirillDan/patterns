package behavioral.command

internal interface Command {
    fun execute()
}

internal class Receiver {
    fun prepateAction() {
        println("prepare action")
    }

    fun finalAction() {
        println("final action")
    }

    fun action1() {
        println("make action1")
    }

    fun action2() {
        println("make action2")
    }
}

internal class ConcreteCommand1(private val receiver: Receiver) : Command {
    override fun execute() {
        receiver.prepateAction()
        receiver.action1()
        receiver.finalAction()
    }
}

internal class ConcreteCommand2(private val receiver: Receiver) : Command {
    override fun execute() {
        receiver.prepateAction()
        receiver.action2()
        receiver.finalAction()
    }
}

internal class Invoker(private val concreteCommand1: Command, private val concreteCommand2: Command) {
    fun makeAction1() {
        concreteCommand1.execute()
    }

    fun makeAction2() {
        concreteCommand2.execute()
    }
}

fun main(args: Array<String>) {
    val receiver = Receiver()
    val concreteCommand1: Command = ConcreteCommand1(receiver)
    val concreteCommand2: Command = ConcreteCommand2(receiver)
    val invoker = Invoker(concreteCommand1, concreteCommand2)
    invoker.makeAction1()
    println()
    invoker.makeAction2()
}
