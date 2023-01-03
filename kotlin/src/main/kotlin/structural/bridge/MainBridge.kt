package structural.bridge

internal interface Motor {
    public fun getHorsepower(): Int
}

class StockMotor : Motor {
    override fun getHorsepower(): Int {
        return 250;
    }
}

class RaceMotor : Motor {
    override fun getHorsepower(): Int {
        return 1000;
    }
}

internal abstract class Car {
    protected var motor: Motor
        get() {return field}
        private set
    public constructor(motor: Motor) {
        this.motor = motor
    }
    abstract public fun getType(): String
}

internal class PassengerCar(motor: Motor) : Car(motor) {
    override fun getType(): String {
        return "Passenger car with " + motor.getHorsepower() + "hp"
    }
}

internal class SUV(motor: Motor) : Car(motor) {
    override fun getType(): String {
        return "SUV with " + motor.getHorsepower() + "hp"
    }
}

fun main(args: Array<String>) {
    val raceSUV: Car = SUV(RaceMotor())
    println(raceSUV.getType())
    val stockCar: Car = PassengerCar(StockMotor())
    println(stockCar.getType())
}