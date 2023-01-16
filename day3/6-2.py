# 6.2+
# 직접 추측해서 맞히는 게임으로 개조한 버전
# (기존 문제의 답안은 이전 버전으로 commit 하였습니다.)

import random

guess_me = random.randint(1, 10)
game_cnt = 1

print('if you wanna quit, type "Q" here.')

while True:
    number = input('\ntype an integer (1~10): ')
    terminate = False
    
    while True:
        # 나간다 하면 보내주기
        if number.upper() == 'Q':
            terminate = True    # 나갈 사람이라고 도장을 찍어준다

        # 이상하게 입력했으면 또 입력하라고 잔소리한다
        elif not 1 <= int(number) <= 10:
            number = input('\nout of range.\n'
                           'type an integer (1~10): ')
            continue

        break

    # 도장 찍은 사람은 내보내준다
    if terminate:
        break

    # 숫자 검사하는 구간
    number = int(number)
    if number < guess_me:
        print('too low')

    elif number == guess_me:
        print(f'found it at {game_cnt} times!')
        break
    
    else:
        print('too high')
            
    game_cnt += 1

print('see you later~')
