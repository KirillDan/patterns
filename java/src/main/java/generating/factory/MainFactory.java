package generating.factory;

enum CarType {
	PassengerCar("Passenger car"), SUV("SUV");

	private String type;

	CarType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return this.type;
	}
}

interface Car {
	public String getCarType();
}

class PassengerCar implements Car {
	@Override
	public String getCarType() {
		return CarType.PassengerCar.getDescription();
	}
}

class SUV implements Car {
	@Override
	public String getCarType() {
		return CarType.SUV.getDescription();
	}
}

class CarFactory {
	Car getCar(final CarType type) {
		switch (type) {
		case PassengerCar:
			return new PassengerCar();
		case SUV:
			return new SUV();
		default:
			return null;
		}
	}
}

public class MainFactory {
	public static void main(String[] args) {
		CarFactory carFactory = new CarFactory();
		Car car = carFactory.getCar(CarType.PassengerCar);
		System.out.println(car.getCarType());
		car = carFactory.getCar(CarType.SUV );
		System.out.println(car.getCarType());
	}
}
