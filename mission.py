import random
small = bool(random.randint(0, 1))  # 랜덤하게 True나 False 값을 부여한다.
green = bool(random.randint(0, 1))

if small:
    if green:
        print('pea')
    else:
        print('cherry')
else:
    if green:
        print('watermelon')
    else:
        print('pumpkin')