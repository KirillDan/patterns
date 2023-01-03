package behavioral.observer

import kotlin.random.Random

internal interface Observer {
    fun update(data: String)
}

internal class ConcreteObserver : Observer {
    private val i: Int = Random(1).nextInt()
    override fun update(data: String) {
        println("$data $i")
    }
}

internal interface Subject {
    fun attach(observer: Observer)
    fun detach(observer: Observer)
    fun notifyObservers()
}

internal class ConcreteSubject : Subject {
    lateinit var subjectState: String
    private val observers: MutableSet<Observer> = mutableSetOf()
    override fun attach(observer: Observer) {
        observers.add(observer)
    }

    override fun detach(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObservers() {
        for (observer in observers) {
            observer.update(subjectState)
        }
    }
}

fun main(args: Array<String>) {
    val observer1: Observer = ConcreteObserver()
    val observer2: Observer = ConcreteObserver()
    val concreteSubject = ConcreteSubject()
    concreteSubject.attach(observer1)
    concreteSubject.attach(observer2)
    concreteSubject.subjectState = "Hello"
    concreteSubject.notifyObservers()
}