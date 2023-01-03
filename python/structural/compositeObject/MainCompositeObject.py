import random
from abc import ABC, abstractmethod

class Element(ABC):
    @abstractmethod
    def render(self) -> str:
        pass

class Text(Element):
    def __init__(self, text: str):
        self.id = random.random()
        self.text = text

    def render(self) -> str:
        return self.text;

class View(Element):
    def __init__(self):
        self.id = random.random()
        self.elements: [Element] = list()

    def render(self) -> str:
        result: str = "";
        for element in self.elements:
            result += element.render() + "\n"
        return result

    def add(self, element: Element):
        self.elements.append(element)

    def remove(self, element: Element):
        self.elements.remove(element)

    def getChilds(self) -> [Element]:
        return self.elements

def main():
    text1 = Text("text1")
    text2 = Text("text2")
    view = View()
    view.add(text1)
    view.add(text2)
    view2 = View()
    text3 = Text("text3")
    view2.add(view)
    view2.add(text3)
    print(view2.render())

main()