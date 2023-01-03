package structural.compositeObject

import kotlin.random.Random

internal interface Element {
    fun render(): String
}

internal class Text(private val text: String) : Element {
    private val id: Int = Random(1).nextInt()
    override fun render(): String {
        return text
    }

    override fun hashCode(): Int {
        return id
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        val other = obj as Text
        return id == other.id
    }
}

internal class View : Element {
    private val id: Int = Random(2).nextInt()
    private val elements: MutableList<Element> = ArrayList()
    override fun render(): String {
        var result = ""
        for (element in elements) {
            result += "${element.render()}\n"
        }
        return result
    }

    fun add(element: Element) {
        elements.add(element)
    }

    fun remove(element: Element) {
        elements.remove(element)
    }

    val childs: List<Element>
        get() = elements

    override fun hashCode(): Int {
        return id
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        val other = obj as View
        return id == other.id
    }
}

fun main(args: Array<String>) {
    val text1 = Text("text1")
    val text2 = Text("text2")
    val view = View()
    view.add(text1)
    view.add(text2)
    val view2 = View()
    val text3 = Text("text3")
    view2.add(view)
    view2.add(text3)
    println(view2.render())
}

