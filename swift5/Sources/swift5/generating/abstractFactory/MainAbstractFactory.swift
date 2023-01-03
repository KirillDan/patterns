
fileprivate enum CarType: String {
    case PassengerCar = "Passenger car"
    case SUV = "SUV"
}

fileprivate protocol Car {
    func getCarType() -> String;
}

fileprivate class PassengerCar : Car {
	public func getCarType() -> String {
		return CarType.PassengerCar.rawValue;
	}
}

fileprivate class SUV : Car {
	public func getCarType() -> String {
		return CarType.SUV.rawValue;
	}
}

fileprivate protocol AbstractFactory {
	func getTransmission(type: TransmissionType) -> Transmission?;
	func getCarType(value: CarType) -> Car?;
}

fileprivate class CarFactory : AbstractFactory {
    public func getCarType(value: CarType) -> Car? {
        switch value {
        case .PassengerCar:
			return PassengerCar();
		case .SUV:
			return SUV();
		default:
			return nil;
		} 
    }

    public func getTransmission(type: TransmissionType) -> Transmission? {
        return nil;
    }
}

fileprivate enum TransmissionType: String {
	case FiveGear = "5 gear"
	case SixGear = "6 gear"
	case SevenGear = "7 gear"
}

fileprivate protocol Transmission {
	func getType() -> String
}

class DefaultTransmission : Transmission {
	func getType() -> String {
		return TransmissionType.FiveGear.rawValue;
	}
}

class UpgratedTransmission : Transmission {
	func getType() -> String {
		return TransmissionType.SixGear.rawValue;
	}
}

class RaceTransmission : Transmission {
	func getType() -> String {
		return TransmissionType.SevenGear.rawValue;
	}
}

fileprivate class TransmissionFactory : AbstractFactory {
    public func getCarType(value: CarType) -> Car? {
        return nil
    }

    public func getTransmission(type: TransmissionType) -> Transmission? {
        switch type {
        case .SixGear:
			return UpgratedTransmission();
		case .SevenGear:
			return RaceTransmission();
		default:
			return DefaultTransmission();
		} 
    }
}

public class MainAbstractFactory {
	public static func main() {
		let carFactory: AbstractFactory = CarFactory();
		var car: Car? = carFactory.getCarType(value: CarType.PassengerCar);
		print(car!.getCarType());
		car = carFactory.getCarType(value: CarType.SUV);
		print(car!.getCarType());
	}
}