from node import DoubleLinkedNode


def append(*data):
    global head

    for d in data:
        # 하나도 없는 경우
        if not head:
            head = DoubleLinkedNode(d)
        else:
            last = head

            # 끝까지 간 다음
            while last.next:
                last = last.next

            # 끝에 데이터를 추가하고, 이전 링크를 붙인다.
            node = DoubleLinkedNode(d)
            last.next = node
            node.prev = last


def print_to_end(current):
    print('정방향 -->', end=' ')

    while True:
        print(current.data, end=' ')
        if current.next is None: break
        current = current.next

    print()
    return current


def print_to_head(current):
    print('역방향 -->', end=' ')

    while True:
        print(current.data, end=' ')
        if current.prev is None: break
        current = current.prev

    print()


if __name__ == "__main__":
    head = None
    append('다현', '정연', '쯔위', '사나', '지효')

    tail = print_to_end(head)
    print_to_head(tail)
