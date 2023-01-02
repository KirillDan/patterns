from random import random
from threading import Lock

class Singleton:
    __instance = None

    def __init__(self):
        pass

    @classmethod
    def getInstance(cls):
        lock = Lock()
        if cls.__instance == None:
            lock.acquire()
            if cls.__instance == None:
                cls.__instance = Singleton()
                cls.__instance.__setValue(random())
            lock.release()
        return cls.__instance

    def __setValue(self, value):
        self.__value = value

    def getValue(self):
        return self.__value


print(Singleton().getInstance().getValue())
print(Singleton().getInstance().getValue())
print(Singleton().getInstance().getValue())