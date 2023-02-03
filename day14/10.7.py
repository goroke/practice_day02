# 10.7
class Element:
    def __init__(self, name, symbol, number):
        self.name = name
        self.symbol = symbol
        self.number = number

    def __str__(self):
        return '\n'.join([f'{attr}: {self.__getattribute__(attr)}' for attr in ('name', 'symbol', 'number')])



el_dict = {'name': 'Hydrogen', 'symbol': 'H', 'number': 1}
print(hydrogen := Element(**el_dict))
