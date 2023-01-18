class calc:
    SYMBOLS = ('+', '-', '*', '/', '**')
    DIGITS = (0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

    def __init__(self):
        self._query = ['0']

    @staticmethod
    def is_num(expression):
        try:
            float(expression)
        except ValueError:
            return False
        else:
            return True

    def _signal(self, sign):
        if self._current_input in calc.SYMBOLS:
            self._current_input = sign
        else:
            self._query.append(sign)

    def plus(self):
        self._signal('+')

    def minus(self):
        self._signal('-')

    def multiply(self):
        self._signal('*')

    def divide(self):
        self._signal('/')

    def power(self):
        self._signal('**')

    def digit(self, n):
        if n not in calc.DIGITS:
            raise ValueError(f'계산기에 "{n}" 버튼이 어딨습니까 휴먼')

        if calc.is_num(self._current_input):
            # 현재 항이 0 이면, 그냥 현재 숫자로 대체하고, 아니면 숫자를 추가한다.
            self._current_input = (self._current_input if self._current_input != '0' else '') + str(n)

        elif self._current_input in calc.SYMBOLS:
            self._query.append(str(n))

    def dot(self):
        if calc.is_num(self._current_input):
            # 현재 항이 실수이고, 점이 없을 때만 점을 찍는다.
            if '.' not in self._current_input:
                self._current_input += '.'

        elif self._current_input in calc.SYMBOLS:
            # 아무것도 없는데 점만 찍으면 부자연스러우므로 0을 같이 적어준다.
            self._query.append('0.')

    def bracket(self, open=True):
        # 힘들어서 이건 나중에
        pass

    def calculate(self):
        # 기호로 끝나버리는 경우는 그 기호를 빼 버릴 것
        if self._current_input in calc.SYMBOLS:
            self._query.pop()

        return eval(self.expression)

    @property
    def expression(self):
        return ''.join(self._query)

    @property
    def _current_input(self):
        return self._query[-1]

    @_current_input.setter
    def _current_input(self, v):
        self._query[-1] = v

    def __str__(self):
        return self.expression


a = calc()

a.digit(3)
a.plus()
a.digit(9)
a.dot()
a.digit(3)
a.multiply()
a.digit(1)
a.digit(0)
a.divide()
a.digit(5)
a.power()
a.digit(3)

print(a)
print(a.calculate())
