# 10.4
class Element:
    def __init__(self, name, symbol, number):
        self.name = name
        self.symbol = symbol
        self.number = number


hydrogen = Element(name='Hydrogen', symbol='H', number=1)

print('- info about the instance <hydrogen> -')
for attr in 'name', 'symbol', 'number':
    print(f'{attr}: {hydrogen.__getattribute__(attr)}')
