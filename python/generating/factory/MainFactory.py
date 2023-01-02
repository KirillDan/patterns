from enum import Enum
from abc import ABC, abstractmethod

class CarType(Enum):
    PassengerCar = "Passenger car"
    SUV = "SUV"

class Car(ABC):
    @abstractmethod
    def getCarType(self):
        pass

class PassengerCar(Car):
    def getCarType(self):
        return CarType.PassengerCar.value

class SUV(Car):
    def getCarType(self):
        return CarType.SUV.value

class CarFactory:
    def getCar(self, type):
        if (isinstance(type, CarType)):
            match type:
                case CarType.PassengerCar:
                    return PassengerCar()
                case CarType.SUV:
                    return SUV()
        else:
            return None

def main():
    carFactory = CarFactory()
    car = carFactory.getCar(CarType.PassengerCar)
    print(car.getCarType())
    car = carFactory.getCar(CarType.SUV)
    print(car.getCarType())

main()