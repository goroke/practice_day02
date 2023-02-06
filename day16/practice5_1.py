# 노드 관련 코드는 node.py 에 따로 작성했습니다.
from node import Node
from random import randint


def insert_data(name, x, y):
    global head
    node = Node((name, x, y))

    # 데이터가 아무것도 없을 경우
    if head is None:
        head = node
        head.link = head  # 원형 리스트로 만든다.
        return

    # 데이터가 있는 경우
    current = head
    nearer = lambda: current.data[1]**2 + current.data[2]**2 > x*x + y*y

    # 헤드보다 가까우면 헤드 자리를 차지한다.
    if nearer():
        last = head

        while last.link != head:
            last = last.link

        last.link = node
        node.link = current
        head = node
        return

    # 헤드보단 안 가까운 경우
    pre = current
    current = current.link

    while True:
        if nearer():
            pre.link = node
            node.link = current
            return

        if current.link == head:
            break

        pre = current
        current = current.link

    # 제일 먼 경우
    current.link = node
    node.link = head


if __name__ == "__main__":
    # 원형 연결 리스트 만들기
    head = None
    for name in 'ABCDEFGHIJ':
        x, y = (randint(1, 100) for i in 'xy')
        insert_data(name, x, y)

    # 결과물 출력
    current = head
    while True:
        name, x, y = current.data
        print(f'{name} 편의점, 거리: {(x*x + y*y)**.5}')
        current = current.link

        if current == head:
            break
