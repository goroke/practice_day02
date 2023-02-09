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


array=list(range(1000))
random.shuffle(array)
quick_sort(array)