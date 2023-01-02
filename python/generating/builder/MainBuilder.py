from dataclasses import dataclass
from abc import ABC, abstractmethod

@dataclass
class Headphone:
    type: str
    loudspeakerType: str
    bodyType: str
    wireType: str

class HeadphoneParts(ABC):
    def setType(self):
        pass
    def setLoudspeaker(self, loudspeakerType: str):
        pass
    def setBody(self, bodyType: str):
        pass
    def setWire(self, wireType: str):
        pass
    def build(self):
        pass

class HiFiHeadphoneParts(HeadphoneParts):
    __type: str
    __loudspeakerType: str
    __bodyType: str
    __wireType: str

    def setType(self):
        self.__type = "Hi-Fi"
        return self
    def setLoudspeaker(self, loudspeakerType):
        self.__loudspeakerType = loudspeakerType
        return self
    def setBody(self, bodyType):
        self.__bodyType = bodyType
        return self
    def setWire(self, wireType):
        self.__wireType = wireType
        return self
    def build(self):
        return Headphone(type = self.__type, loudspeakerType = self.__loudspeakerType, bodyType = self.__bodyType, wireType = self.__wireType)

class HiEndHeadphoneParts(HeadphoneParts):
    __type: str
    __loudspeakerType: str
    __bodyType: str
    __wireType: str

    def setType(self):
        self.__type = "Hi-End"
        return self
    def setLoudspeaker(self, loudspeakerType):
        self.__loudspeakerType = loudspeakerType
        return self
    def setBody(self, bodyType):
        self.__bodyType = bodyType
        return self
    def setWire(self, wireType):
        self.__wireType = wireType
        return self
    def build(self):
        return Headphone(type = self.__type, loudspeakerType = self.__loudspeakerType, bodyType = self.__bodyType, wireType = self.__wireType)

class Engineer:
    __headphoneParts: HeadphoneParts

    def __init__(self, headphoneParts):
        self.__headphoneParts = headphoneParts
    def buildHeadphone(self):
        if (isinstance(self.__headphoneParts, HiFiHeadphoneParts)):
            return self.__headphoneParts\
                .setType()\
                .setLoudspeaker("First class")\
                .setBody("First class")\
                .setWire("First class")\
                .build()
        elif (isinstance(self.__headphoneParts, HiEndHeadphoneParts)):
            return self.__headphoneParts\
                .setType() \
                .setLoudspeaker("Premium class")\
                .setBody("Premium class")\
                .setWire("Premium class")\
                .build()
        else:
            return None

def  main():
    engineer1 = Engineer(HiFiHeadphoneParts())
    hifi = engineer1.buildHeadphone()
    print(hifi)
    engineer2 = Engineer(HiEndHeadphoneParts())
    hiend = engineer2.buildHeadphone()
    print(hiend)

main()

