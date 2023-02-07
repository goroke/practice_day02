from data_structure import Queue

if __name__ == "__main__":
    waiting = Queue(5)
    for guest in '정국', '뷔', '지민', '진', '슈가':
        waiting.enqueue(guest)

    while not waiting.is_empty():
        print(f'대기 줄 상태 : {waiting}')
        print(f'{waiting.dequeue()} 님 식당에 들어감')
        waiting.shift()

    print(f'대기 줄 상태 : {waiting}')
    print('식당 영업 종료!')
