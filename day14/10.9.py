# 10.9
class Bear:
    def eats(self):
        return 'berries'


class Rabbit:
    def eats(self):
        return 'clover'


class Octothorpe:
    def eats(self):
        return 'campers'


# 클래스마다 인스턴스 생성
animals = [X() for X in (Bear, Rabbit, Octothorpe)]

for animal in animals:
    print(animal.eats())
