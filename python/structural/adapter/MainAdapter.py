from abc import ABC, abstractmethod

class OldService:
    def requestOld(self, valueOld: str):
        if (isinstance(valueOld, str)):
            return "result with old value = " + valueOld
        else:
            raise ValueError

class NewService(ABC):
    @abstractmethod
    def requestNew(self, valueNew: int):
        pass

class AdapterFromNewToOld(NewService):
    def __init__(self, oldService: OldService):
        if (isinstance(oldService, OldService)):
            self.oldService = oldService
        else:
            raise ValueError

    def requestNew(self, valueNew: int):
        if (isinstance(valueNew, int)):
            return self.oldService.requestOld(self.__convertValueFromNewToOld(valueNew))
        else:
            raise ValueError

    def __convertValueFromNewToOld(self, valueNew: int):
        if (isinstance(valueNew, int)):
            return str(valueNew)
        else:
            raise ValueError

def main():
    oldService = OldService()
    adapterFromNewToOld = AdapterFromNewToOld(oldService)
    result = adapterFromNewToOld.requestNew(11)
    print(result)

main()