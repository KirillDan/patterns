
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
	// public func getTransmission(type: TransmissionType) -> Transmission?;
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

    // public func getTransmission(type: TransmissionType) -> Transmission? {
    //     return nil;
    // }
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