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
    with open('practice.txt', 'r', encoding='MS949') as file_stream:
        file = file_stream.read()

    print(f'----- 원본 -----')

    SIZE = len(file)
    stack = [None] * SIZE
    top = -1

    for letter in file:
        push(letter)
        print(letter, end='')

    print(f'----- 거꾸로 처리된 결과 -----')

    # 스택에 아무것도 없을 때까지 pop 수행
    while not is_empty_stack():
        print(pop(), end='')
