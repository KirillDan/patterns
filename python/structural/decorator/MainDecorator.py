from abc import ABC, abstractmethod

class Component(ABC):
    @abstractmethod
    def operation(self) -> str: pass


class ConcreteComponent(Component):
    def operation(self) -> str:
        return "concrete operation"


class Decorator(Component):
    _component: Component


class ConcreteDecorator1(Decorator):
    def __init__(self, component: Component):
        self._component = component

    def operation(self) -> str:
        return self.__class__.__name__ + self._component.operation()



class ConcreteDecorator2(Decorator):
    def __init__(self, component: Component):
        self._component = component

    def operation(self) -> str:
        return self.__class__.__name__ + self._component.operation()


def main():
    component = ConcreteComponent()
    concreteDecorator1 = ConcreteDecorator1(component)
    concreteDecorator2 = ConcreteDecorator2(component)
    print(concreteDecorator1.operation())
    print(concreteDecorator2.operation())

main()