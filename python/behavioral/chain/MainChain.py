from abc import ABC, abstractmethod

class Element(ABC):
    @abstractmethod
    def operation(self, i: int):
        pass

class LastElement(Element):
    def operation(self, i: int):
        print("last " + str(i) + " operation")



class IterElement(Element):
    def __init__(self, element: Element):
        self.__element = element

    def operation(self, i: int):
        print(str(i) + " operation");
        self.__element.operation(i + 1)


def main():
    lastElement = LastElement()
    iterElement2 = IterElement(lastElement)
    iterElement1 = IterElement(iterElement2)
    iterElement1.operation(1)

main()
