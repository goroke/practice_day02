# 10.6
class Element:
    def __init__(self, name, symbol, number):
        self.name = name
        self.symbol = symbol
        self.number = number

    def dump(self):
        for attr in 'name', 'symbol', 'number':
            print(f'{attr}: {self.__getattribute__(attr)}')


el_dict = {'name': 'Hydrogen', 'symbol': 'H', 'number': 1}
(hydrogen := Element(**el_dict)).dump()
