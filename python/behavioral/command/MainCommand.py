from abc import ABC, abstractmethod

class Command(ABC):
    @abstractmethod
    def execute(self):
        pass


class Receiver:
    def prepateAction(self):
        print("prepare action")

    def finalAction(self):
        print("final action")

    def action1(self):
        print("make action1")

    def action2(self):
        print("make action2")



class ConcreteCommand1(Command):
    def __init__(self, receiver: Receiver):
        self.__receiver = receiver

    def execute(self):
        self.__receiver.prepateAction()
        self.__receiver.action1()
        self.__receiver.finalAction()


class ConcreteCommand2(Command):
    def __init__(self, receiver: Receiver):
        self.__receiver = receiver

    def execute(self):
        self.__receiver.prepateAction()
        self.__receiver.action2()
        self.__receiver.finalAction()


class Invoker:
    def __init__(self, concreteCommand1: Command, concreteCommand2: Command):
        self.__concreteCommand1 = concreteCommand1
        self.__concreteCommand2 = concreteCommand2

    def makeAction1(self):
        self.__concreteCommand1.execute()

    def makeAction2(self):
        self.__concreteCommand2.execute()

def main():
    receiver = Receiver()
    concreteCommand1 = ConcreteCommand1(receiver)
    concreteCommand2 = ConcreteCommand2(receiver)
    invoker = Invoker(concreteCommand1, concreteCommand2)
    invoker.makeAction1()
    print()
    invoker.makeAction2()

main()