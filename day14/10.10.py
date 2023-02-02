# 10.10
class Laser:
    def does(self):
        return 'disintegrate'


class Claw:
    def does(self):
        return 'crush'


class SmartPhone:
    def does(self):
        return 'ring'


class Robot:
    def __init__(self):
        self.laser = Laser()
        self.claw = Claw()
        self.smartphone = SmartPhone()

    def does(self):
        for part in 'laser', 'claw', 'smartphone':
            print(f'{part}: {self.__getattribute__(part).does()}')


(robot := Robot()).does()
