def is_full_stack():
    global SIZE, stack, top
    return top + 1 >= SIZE


def is_empty_stack():
    global SIZE, stack, top
    return top == -1


def push(item):
    global SIZE, stack, top
    if is_full_stack(): return
    top += 1
    stack[top] = item


def pop():
    global SIZE, stack, top
    if is_empty_stack(): return
    ret = stack[top]
    stack[top] = None
    top -= 1
    return ret


def peek():
    global SIZE, stack, top
    return stack[top]


if __name__ == "__main__":
    SIZE = 6
    stack = [None] * SIZE
    top = -1

    data_array = ['빨강', '주황', '노랑', '초록', '파랑', '보라']

    # 본격적인 출력
    print('과자집에 가는길 : ', end='')

    for data in data_array:
        push(data)
        print(f'{data} -->', end='')

    print('과자집\n우리집에 오는길 : ', end='')

    while not is_empty_stack():
        print(f'{pop()} -->', end='')

    print('우리집')