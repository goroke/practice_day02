from random import choice, choices
from sys import setrecursionlimit


# 함수 호출 횟수를 세는 데커레이터
def count_when_called(func):
    def inner(*args, **kwargs):
        global called_count
        try:
            called_count[func.__name__] += 1
        except KeyError:
            called_count[func.__name__] = 0
        return func(*args, **kwargs)

    return inner


# 이진 검색
@count_when_called
def binary_search(data: list, find: str, start=None, end=None):
    if start is None: start = 0
    if end is None: end = len(data)-1

    mid = (start + end) // 2

    # 못 찾은 경우
    if start > end:
        return -1

    # 찾은 경우
    if data[mid] == find:
        return mid

    # 큰 경우
    elif data[mid] < find:
        return binary_search(data, find, mid+1, end)

    # 작은 경우
    else:
        return binary_search(data, find, start, mid-1)


# 순차 검색
@count_when_called
def sequential_search(data: list, find, point=0):
    # 못 찾은 경우
    if point >= len(data):
        return -1

    # 찾은 경우
    if data[point] == find:
        return point

    # 찾고 있는 경우
    else:
        return -1


# 데이터 준비
data = choices(range(1000000), k=1000000)
data_sorted = sorted(data)

# 데이터 출력
print('#비정렬 배열(100만개) -->', data[:5], '~~~~', data[-5:], '\n'
      '#정렬 배열(100만개) -->', data_sorted[:5], '~~~~', data_sorted[-5:])

# 검색 대상을 랜덤하게 지정
target = choice(data)

# 함수 호출 횟수가 들어가는 곳 {함수명: 호출 횟수}
called_count = {}

# 순차 검색 수행
seq_position = 0
while sequential_search(data, target, seq_position) == -1: seq_position += 1

# 이진 검색 수행
binary_search(data_sorted, target)

# 결과물 출력
print('순차 검색(비정렬 데이터) -->', called_count['sequential_search'], '회\n'
      '이진 검색(정렬 데이터) -->', called_count['binary_search'], '회')
