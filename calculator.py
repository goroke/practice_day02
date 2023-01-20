def calculate(expression):
    DIGITS = '1234567890.'
    OPERS = ('*', '/', '+', '-')
    OPER_COMMAND = {'+': lambda x, y: x + y,
                    '-': lambda x, y: x - y,
                    '*': lambda x, y: x * y,
                    '/': lambda x, y: x / y}

    # 숫자와 연산자를 분리하여 저장할 곳 ( 1+2 → [1, '+', 2] )
    buffer = []

    # 문자열 전체를 순환하며 buffer를 채운다.
    start_point = end_point = 0
    while end_point < len(expression):

        # 현재 부분이 숫자인 경우 숫자 부분을 감지해서 buffer 에 추가
        if (char := expression[start_point]) in DIGITS:
            while end_point < len(expression) - 1 and expression[end_point + 1] in DIGITS:
                end_point += 1

            # print(char)
            buffer.append(expression[start_point:end_point + 1])

        # 괄호인 경우 괄호 안 내용 전부를 buffer 에 추가
        elif char == '(':
            while (bracket_area := expression[start_point:end_point + 1]).count('(') != bracket_area.count(')'):
                end_point += 1

            # 괄호 안의 내용은 별도로 계산하도록 한다
            buffer.append(calculate(bracket_area[1:-1]))

        # 연산자인 경우
        # 2글자 이상의 연산자가 나오면 변경해야 함
        elif char in OPERS:
            buffer.append(char)

        # 이도저도 아닌 경우는 잘못된 입력이므로 에러가 발생해야 한다.
        else:
            raise ValueError

        # 내용을 buffer 에 추가했으면, 다음 내용을 buffer 에 추가하기 위해 준비
        start_point = end_point = end_point + 1

        # print(buffer)

    # 부호로 시작하는 경우도 있을 수 있으니, 앞에 0을 넣어서 정상적인 덧셈/뺄셈 연산을 수행하게 한다.
    if buffer[0] in ('+', '-'):
        buffer.insert(0, 0)

    # buffer 에 담긴 내용을 전부 계산 (계산이 끝나면 단 1개의 계산 결과가 담긴 리스트가 될 것이다.)
    while len(buffer) > 1:
        for oper in OPERS:
            while buffer.count(oper):
                idx = buffer.index(oper)

                # 자신과 양 옆을 계산해서 결과물로 치환 ( [1, '+', 2] → [3] )
                buffer[idx-1:idx+2] = [OPER_COMMAND[oper](float(buffer[idx-1]), float(buffer[idx+1]))]
                # print(buffer)

    # 계산 결과 리턴
    return buffer[0]


print(calculate('(1+2+3+4+5)*6-7-8*(9/10)'))
