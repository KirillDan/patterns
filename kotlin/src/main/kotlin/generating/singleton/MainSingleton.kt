package generating.singleton

import kotlin.random.Random

internal class Singleton private constructor() {
    val value: Int = Random.nextInt()

    companion object {
        var instance: Singleton? = null
            get() {
                if (field == null) {
                    synchronized(Singleton::class) {
                        if (field == null) {
                            field = Singleton()
                        }
                    }
                }
                return field
            }
            private set
    }
}

fun main() {
    val singleton1: Singleton = Singleton.instance!!
    println(singleton1.value)
    val singleton2: Singleton = Singleton.instance!!
    println(singleton2.value)
    println(singleton2 == singleton1)
}