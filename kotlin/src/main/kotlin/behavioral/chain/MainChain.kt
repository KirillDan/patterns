package behavioral.chain

internal interface Element {
    fun operation(i: Int)
}

internal class LastElement : Element {
    override fun operation(i: Int) {
        println("last $i operation")
    }
}

internal class IterElement(private val element: Element) : Element {
    override fun operation(i: Int) {
        println("$i operation")
        element.operation(i + 1)
    }
}

fun main(args: Array<String>) {
    val lastElement: Element = LastElement()
    val iterElement2: Element = IterElement(lastElement)
    val iterElement1: Element = IterElement(iterElement2)
    iterElement1.operation(1)
}
