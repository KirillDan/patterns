package generating.factory

enum class CarType {
    PassengerCar("Passenger car"), SUV("SUV");

    private val type: String;

    constructor(type: String) {
        this.type = type;
    }

    public fun getDescription(): String {
        return this.type;
    }
}

internal interface Car {
    val carType: String
}

internal class PassengerCar : Car {
    override val carType: String
        get() = CarType.PassengerCar.getDescription()
}

internal class SUV : Car {
    override val carType: String
        get() = CarType.SUV.getDescription()
}

internal class CarFactory {
    fun getCar(type: CarType): Car? {
        return when (type) {
            CarType.PassengerCar -> PassengerCar()
            CarType.SUV -> SUV()
            else -> null
        }
    }
}

fun main() {
    val carFactory = CarFactory()
    var car = carFactory.getCar(CarType.PassengerCar)
    println(car?.carType)
    car = carFactory.getCar(CarType.SUV)
    println(car?.carType)
}