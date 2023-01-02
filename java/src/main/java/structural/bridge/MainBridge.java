package structural.bridge;

interface Motor {
	public Integer getHorsepower();
}

class StockMotor implements Motor {
	@Override
	public Integer getHorsepower() {
		return 250;
	}
}

class RaceMotor implements Motor {
	@Override
	public Integer getHorsepower() {
		return 1000;
	}
}

abstract class Car {
	protected Motor motor;
	public Car(Motor motor) {
		this.motor = motor;
	}
	abstract public Motor getMotor();
	abstract public String getType();
}

class PassengerCar extends Car {
	public PassengerCar(Motor motor) {
		super(motor);
	}

	@Override
	public Motor getMotor() {
		return motor;
	}

	@Override
	public String getType() {
		return "Passenger car with " + this.motor.getHorsepower() + "hp";
	}
}

class SUV extends Car {
	public SUV(Motor motor) {
		super(motor);
	}

	@Override
	public Motor getMotor() {
		return motor;
	}
	
	@Override
	public String getType() {
		return "SUV with " + this.motor.getHorsepower() + "hp";
	}
}

public class MainBridge {
	public static void main(String[] args) {
		Car raceSUV = new SUV(new RaceMotor());
		System.out.println(raceSUV.getType());
		Car stockCar = new PassengerCar(new StockMotor());
		System.out.println(stockCar.getType());
	}
}
