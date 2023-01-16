# 6.3+
# 업다운 게임
# (기존 문제의 답안은 이전 버전으로 commit 하였습니다.)

import random

guess_me = random.randint(1, 10)
game_cnt = 1

print('if you wanna quit, type "Q" here.')

# 밸런스 조절을 위해 기회를 3번 부여
for game_cnt in range(1, 4):

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
        print(f'too low (chance {game_cnt}/3)')

    elif number == guess_me:
        print(f'found it at {game_cnt} times!')
        break
    
    else:
        print(f'too high (chance {game_cnt}/3)')
            
    game_cnt += 1

else:
    print(f"\ngame over\nthe answer was {guess_me}")

print('see you later~')
