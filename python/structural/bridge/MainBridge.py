from abc import ABC, abstractmethod

class Motor(ABC):
    @abstractmethod
    def getHorsepower(self) -> int:
        pass

class StockMotor(Motor):
    def getHorsepower(self) -> int:
        return 250

class RaceMotor(Motor):
    def getHorsepower(self) -> int:
        return 1000

class Car(ABC):
    def __init__(self, motor: Motor):
        if (isinstance(motor, Motor)):
            self._motor = motor
        else:
            raise ValueError

    def getMotor(self):
        return self._motor
    @abstractmethod
    def getType(self):
        pass

class PassengerCar(Car):
    def getType(self) -> str:
        return "Passenger car with " + str(self._motor.getHorsepower()) + "hp"

class SUV(Car):
    def getType(self) -> str:
        return "SUV with " + str(self._motor.getHorsepower()) + "hp"

def main():
    raceSUV: Car = SUV(RaceMotor())
    print(raceSUV.getType())
    stockCar: Car = PassengerCar(StockMotor())
    print(stockCar.getType())

main()