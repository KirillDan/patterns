import random
from abc import ABC, abstractmethod

class Observer(ABC):
    @abstractmethod
    def update(self, data: str):
        pass


class ConcreteObserver(Observer):
    def __init__(self):
        self.__i = random.random()
    def update(self, data: str):
        print(data + " " + str(self.__i))

class Subject(ABC):
    def attach(self, observer: Observer):
        pass
    def detach(self, observer: Observer):
        pass
    def notifyObservers(self):
        pass

class ConcreteSubject(Subject):
    def __init__(self):
        self.__subjectState: str = None
        self.__observers: set[Observer] = set()

    def attach(self, observer: Observer):
        self.__observers.add(observer)

    def detach(self, observer: Observer):
        self.__observers.remove(observer)

    def notifyObservers(self):
        for observer in self.__observers:
            observer.update(self.__subjectState)

    def getSubjectState(self):
        return self.__subjectState

    def setSubjectState(self, subjectState: str):
        self.__subjectState = subjectState


def main():
    observer1 = ConcreteObserver()
    observer2 = ConcreteObserver()
    concreteSubject = ConcreteSubject()
    concreteSubject.attach(observer1)
    concreteSubject.attach(observer2)
    concreteSubject.setSubjectState("Hello")
    concreteSubject.notifyObservers()
    concreteSubject.setSubjectState("Message")
    concreteSubject.notifyObservers()

main()

