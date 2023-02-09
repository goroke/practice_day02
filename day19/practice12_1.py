import random
from time import time


def selection_sort(array):
    for start in range(0, len(array)-2):
        minimum = start

        for current in range(start+1, len(array)):
            if array[minimum] > array[current]:
                minimum = current

        array[minimum], array[start] = array[start], array[minimum]


def quick_sort(array, start=None, end=None):
    if start is None:
        start = 0
    if end is None:
        end = len(array) - 1

    if end - start < 1: return

    pivot = array[(start + end) // 2]
    high = end
    low = start

    while high >= low:
        while array[high] > pivot:
            high -= 1
        while array[low] < pivot:
            low += 1

        if high >= low:
            array[high], array[low] = array[low], array[high]
            high -= 1
            low += 1

    quick_sort(array, start, low-1)
    quick_sort(array, low, end)


for size in 1000, 10000, 12000, 15000:
    test_array = list(range(size))
    random.shuffle(test_array)
    s_array = test_array[:]
    q_array = test_array[:]

    start = time()
    selection_sort(s_array)
    s_time = time() - start

    start = time()
    quick_sort(q_array)
    q_time = time() - start

    print(f'## 데이터 수 :   {size} 개')
    print(('   %s 정렬 -->\t%.3f 초\n' * 2) % ('선택', s_time, '퀵', q_time))
