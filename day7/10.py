# 10.1
print('\n10.1')


class Thing:
    pass


print(f'Thing 클래스 출력: {Thing}')

example = Thing()
print(f'Example 출력: {example}')


# 10.2
print('\n10.2')


class Thing2:
    letters = 'abc'


print(f'Thing2.letters = {Thing2.letters}')


# 10.3
print('\n10.3')


class Thing3:
    pass


(instance := Thing3()).letters = 'xyz'
print(f'instance.letters = {instance.letters}')
print('letters 속성은 객체 속성이므로, 객체를 생성해야 생깁니다.')


# 10.4
print('\n10.4')


class Element:
    def __init__(self, name, symbol, number):
        self.name = name
        self.symbol = symbol
        self.number = number


el = Element('Hydrogen', 'H', 1)
print(f'el.name = {el.name}')
print(f'el.symbol = {el.symbol}')
print(f'el.number = {el.number}')


# 10.5
print('\n10.5')

el_dict = {'name': 'Hydrogen',
           'symbol': 'H',
           'number': 1
           }

el = Element(**el_dict)
print(f'el.name = {el.name}')
print(f'el.symbol = {el.symbol}')
print(f'el.number = {el.number}')


# 10.6
print('\n10.6')


class Element:
    def __init__(self, name, symbol, number):
        self.name = name
        self.symbol = symbol
        self.number = number

    def dump(self):
        print(f'name   = {self.name}')
        print(f'symbol = {self.symbol}')
        print(f'number = {self.number}')


el = Element(**el_dict)
el.dump()


# 10.7
print('\n10.7')


class Element:
    def __init__(self, name, symbol, number):
        self.name = name
        self.symbol = symbol
        self.number = number

    def __str__(self):
        return f'name   = {self.name}\n' \
               f'symbol = {self.symbol}\n' \
               f'number = {self.number}\n'


el = Element(**el_dict)
print(el)


# 10.8
print('\n10.8')


class Element:
    def __init__(self, name, symbol, number):
        self.__name = name
        self.__symbol = symbol
        self.__number = number

    @property
    def name(self):
        return self.__name

    @property
    def symbol(self):
        return self.__symbol

    @property
    def number(self):
        return self.__number

    def __str__(self):
        return f'name   = {self.name}\n' \
               f'symbol = {self.symbol}\n' \
               f'number = {self.number}\n'


el = Element(**el_dict)
print(el)


# 10.9
print('\n10.9')


class Animal:
    @classmethod
    def eats(cls):
        return cls.food


class Bear(Animal): food = 'berries'
class Rabbit(Animal): food = 'clover'
class Octothrope(Animal): food = 'campers'


b, r, o = Bear(), Rabbit(), Octothrope()
print(f'Bear().eats()       → {b.eats()}')
print(f'Rabbit().eats()     → {r.eats()}')
print(f'Octothrope().eats() → {o.eats()}')


# 10.10
print('\n10.10')


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
    def __init__(self, *components):
        self.__components = components

    def does(self):
        for component in self.__components:
            print(component.does())


rb = Robot(Laser(), Claw(), SmartPhone())
rb.does()
