from abc import ABC, abstractmethod

class Conversion(ABC):
    def _toCM(self, inch: int) -> float:
        return float(inch) * 2.54
    @abstractmethod
    def addCmAndInch(self, cm: int, inch: int) -> float:
        pass

class AddingImpl(Conversion):
    def addCmAndInch(self, cm: int, inch: int) -> float:
        return cm + self._toCM(inch)

def main():
    addingImpl = AddingImpl()
    cm = 1
    inch = 1
    print(str(cm) + " cm + " + str(inch) + " inch = " + str(addingImpl.addCmAndInch(cm, inch)) + " cm")

main()