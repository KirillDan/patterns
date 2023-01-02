
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

fileprivate class CarFactory {
    public func getCar(value: CarType) -> Car? {
        switch value {
        case .PassengerCar:
			return PassengerCar();
		case .SUV:
			return SUV();
		default:
			return nil;
		} 
    }
}

public class MainFactory {
	public static func main() {
		let carFactory: CarFactory = CarFactory();
		var car: Car? = carFactory.getCar(value: CarType.PassengerCar);
		print(car!.getCarType());
		car = carFactory.getCar(value: CarType.SUV);
		print(car!.getCarType());
	}
}