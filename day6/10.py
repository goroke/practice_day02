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


# 10.4
print('\n10.4')


class Element:
    def __init__(self, name, symbol, number):
        self.name = name
        self.symbol = symbol
        self.number = number


Element