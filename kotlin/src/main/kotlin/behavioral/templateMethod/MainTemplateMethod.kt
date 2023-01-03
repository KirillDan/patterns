package behavioral.templateMethod

internal abstract class Conversion {
    fun toCM(inch: Int): Float {
        return inch * 2.54f
    }

    abstract fun addCmAndInch(cm: Int, inch: Int): Float
}

internal class AddingImpl : Conversion() {
    override fun addCmAndInch(cm: Int, inch: Int): Float {
        return cm + toCM(inch)
    }
}

fun main(args: Array<String>) {
    val addingImpl = AddingImpl()
    val cm = 1
    val inch = 1
    println(cm.toString() + " cm + " + inch + " inch = " + addingImpl.addCmAndInch(cm, inch) + " cm")
}
