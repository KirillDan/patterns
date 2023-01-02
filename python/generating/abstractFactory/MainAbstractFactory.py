
from enum import Enum
from abc import ABC, abstractmethod

class CarType(Enum):
    PassengerCar = "Passenger car"
    SUV = "SUV"

class TransmissionType(Enum):
    FiveGear = "5 gear"
    SixGear = "6 gear"
    SevenGear = "7 gear"

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

class Transmission(ABC):
    @abstractmethod
    def getType(self):
        pass

class DefaultTransmission(Transmission):
    def getType(self):
        return TransmissionType.FiveGear.value

class UpgratedTransmission(Transmission):
    def getType(self):
        return TransmissionType.SixGear.value

class RaceTransmission(Transmission):
    def getType(self):
        return TransmissionType.SevenGear.value

class AbstractFactory(ABC):
    @abstractmethod
    def getCarType(self, type: CarType):
        pass

    @abstractmethod
    def getTransmission(type):
        pass

class CarFactory(AbstractFactory):
    def getCarType(self, type):
        if (isinstance(type, CarType)):
            match type:
                case CarType.PassengerCar:
                    return PassengerCar()
                case CarType.SUV:
                    return SUV()
        else:
            return None

    def getTransmission(type):
        return None

class TransmissionFactory(AbstractFactory):
    def getCarType(self, type):
        return None

    def getTransmission(type):
        if (isinstance(type, TransmissionType)):
            match type:
                case TransmissionType.SixGear:
                    return UpgratedTransmission()
                case TransmissionType.SevenGear:
                    return RaceTransmission()
                case _:
                    return DefaultTransmission()
        else:
            return None

def main():
    abstractFactory = CarFactory()
    car = abstractFactory.getCarType(CarType.SUV)
    print(car.getCarType())

main()
