# 10.8
class Element:
    def __init__(self, name, symbol, number):
        self.__name = name
        self.__symbol = symbol
        self.__number = number

    # 원소가 갑자기 바뀔 순 없으니 @name.setter 는 만들지 않는다.
    @property
    def name(self):
        return self.__name

    @property
    def symbol(self):
        return self.__symbol

    @property
    def number(self):
        return self.__number


el_dict = {'name': 'Hydrogen', 'symbol': 'H', 'number': 1}
hydrogen = Element(**el_dict)

print('- info about the instance <hydrogen> -')
for attr in 'name', 'symbol', 'number':
    print(f'{attr}: {hydrogen.__getattribute__(attr)}')
