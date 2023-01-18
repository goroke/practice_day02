# 9.1
print('\n9.1')


def good():
    return 'Harry Ron Hermione'.split()


print(f'good → {good()}')


# 9.2
print('\n9.2')


def get_odds():
    for i in range(10):
        if i % 2:
            yield i


for i, x in enumerate(get_odds(), start=1):
    if i == 3:
        print(x)


# 9.3
print('\n9.3')


def test(func):
    def temp_test(*args, **kwargs):
        print('start')
        result = func(*args, **kwargs)
        print('end')
        return result

    return temp_test


@test
def flatten(original_list):
    changed = False
    result = original_list[:]

    while not changed:
        for idx, elem in enumerate(result):
            try:
                # 리스트/튜플 같은 경우는 자기 자신을 풀어헤친다.
                result[idx:idx+1] = elem
                changed = True
            except TypeError:
                # 안 되는 경우는 그냥 가만히 두면 된다.
                pass

    return result


a = [1, 2, 3, [4, 5, [6, 7, [8, 9]], 10, 11], 12, [13, 14], 15]
print(f'함수 실행 전: {a}')
print(f'함수 실행 결과물: {flatten(a)}')


# 9.4
print('\n9.4')


class OopsException(Exception):
    pass


try:
    raise OopsException('Caught an oops')
except Exception as e:
    print(e)
