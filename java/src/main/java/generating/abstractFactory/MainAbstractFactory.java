package generating.abstractFactory;

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
	public String getType();
}

class PassengerCar implements Car {
	@Override
	public String getType() {
		return CarType.PassengerCar.getDescription();
	}
}

class SUV implements Car {
	@Override
	public String getType() {
		return CarType.SUV.getDescription();
	}
}

class CarFactory extends AbstractFactory {
	public Car getCarType(final CarType type) {
		switch (type) {
		case PassengerCar:
			return new PassengerCar();
		case SUV:
			return new SUV();
		default:
			return null;
		}
	}

	@Override
	public Transmission getTransmission(TransmissionType type) {
		return null;
	}
}

enum TransmissionType {
	FiveGear("5 gear"), SixGear("6 gear"), SevenGear("7 gear");
	
	private String type;

	TransmissionType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return this.type;
	}
}

interface Transmission {
	public String getType();
}

class DefaultTransmission implements Transmission {
	@Override
	public String getType() {
		return TransmissionType.FiveGear.getDescription();
	}
}

class UpgratedTransmission implements Transmission {
	@Override
	public String getType() {
		return TransmissionType.SixGear.getDescription();
	}
}

class RaceTransmission implements Transmission {
	@Override
	public String getType() {
		return TransmissionType.SevenGear.getDescription();
	}
}

class TransmissionFactory extends AbstractFactory {
	public Transmission getTransmission(TransmissionType type) {
		switch (type) {
		case SixGear: return new UpgratedTransmission();
		case SevenGear: return new RaceTransmission();
		default: return new DefaultTransmission();
		}
	}

	@Override
	public Car getCarType(CarType type) {
		return null;
	}
}

abstract class AbstractFactory {
	abstract public Transmission getTransmission(TransmissionType type);
	abstract public Car getCarType(final CarType type);
}

public class MainAbstractFactory {
	public static void main(String[] args) {
		AbstractFactory abstractFactory = new CarFactory();
		Car car = abstractFactory.getCarType(CarType.SUV);
		System.out.println(car.getType());
	}
}
