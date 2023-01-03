fileprivate protocol Motor {
	func getHorsepower() -> Int;
}

fileprivate class StockMotor : Motor {
	public func getHorsepower() -> Int {
		return 250;
	}
}

fileprivate class RaceMotor : Motor {
	public func getHorsepower() -> Int {
		return 1000;
	}
}

fileprivate protocol Car {
	func getMotor() -> Motor
	func getType() -> String
}

fileprivate class PassengerCar : Car {
    private var motor: Motor

	init(_ motor: Motor) {
		self.motor = motor;
	}

	public func getMotor() -> Motor {
		return self.motor
	}

	public func getType() -> String {
		return "Passenger car with " + String(self.motor.getHorsepower()) + "hp";
	}
}

fileprivate class SUV : Car {
	private var motor: Motor

	init(_ motor: Motor) {
		self.motor = motor;
	}

	public func getMotor() -> Motor {
		return self.motor
	}

	public func getType() -> String {
		return "SUV with " + String(self.motor.getHorsepower()) + "hp";
	}
}

public class MainBridge {
	public static func main() {
		let raceSUV = SUV(RaceMotor());
		print(raceSUV.getType())
		let stockCar = PassengerCar(StockMotor());
		print(stockCar.getType());
	}
}