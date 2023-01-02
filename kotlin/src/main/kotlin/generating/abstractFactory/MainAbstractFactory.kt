package generating.abstractFactory

internal enum class CarType(val description: String) {
    PassengerCar("Passenger car"), SUV("SUV");
}

internal interface Car {
    val type: String
}

internal class PassengerCar : Car {
    override val type: String
        get() = CarType.PassengerCar.description
}

internal class SUV : Car {
    override val type: String
        get() = CarType.SUV.description
}

internal class CarFactory : AbstractFactory() {
    override fun getCarType(type: CarType): Car? {
        return when (type) {
            CarType.PassengerCar -> PassengerCar()
            CarType.SUV -> SUV()
            else -> null
        }
    }

    override fun getTransmission(type: TransmissionType): Transmission? {
        return null
    }
}

internal enum class TransmissionType(val description: String) {
    FiveGear("5 gear"), SixGear("6 gear"), SevenGear("7 gear");

}

internal interface Transmission {
    val type: String
}

internal class DefaultTransmission : Transmission {
    override val type: String
        get() = TransmissionType.FiveGear.description
}

internal class UpgratedTransmission : Transmission {
    override val type: String
        get() = TransmissionType.SixGear.description
}

internal class RaceTransmission : Transmission {
    override val type: String
        get() = TransmissionType.SevenGear.description
}

internal class TransmissionFactory : AbstractFactory() {
    override fun getTransmission(type: TransmissionType): Transmission {
        return when (type) {
            TransmissionType.SixGear -> UpgratedTransmission()
            TransmissionType.SevenGear -> RaceTransmission()
            else -> DefaultTransmission()
        }
    }

    override fun getCarType(type: CarType): Car? {
        return null
    }
}

internal abstract class AbstractFactory {
    abstract fun getTransmission(type: TransmissionType): Transmission?
    abstract fun getCarType(type: CarType): Car?
}

fun main(args: Array<String>) {
    val abstractFactory: AbstractFactory = CarFactory()
    val car = abstractFactory.getCarType(CarType.SUV)
    println(car!!.type)
}
