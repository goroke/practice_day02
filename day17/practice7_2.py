from data_structure import CircularQueue

if __name__ == "__main__":
    calls = ('사용', 9), ('고장', 3), ('환불', 4), ('환불', 4), ('고장', 3)
    waiting = CircularQueue(6)
    waiting_time = 0

    for call in calls:
        print(f'귀하의 예상 대기 시간은  {waiting_time} 분입니다.\n'
              f'현재 대기 콜 -->  {waiting}\n')
        waiting.enqueue(call)
        waiting_time += call[1]

    print(f'최종 대기 콜 -->  {waiting}\n'
          '프로그램 종료!')
