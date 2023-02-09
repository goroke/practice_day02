def insertion_sort(array):
    for end in range(1, len(array)):
        for current in range(end, 0, -1):
            if array[current - 1] > array[current]:
                array[current - 1], array[current] = array[current], array[current - 1]


median = lambda x: x[len(x) // 2] if len(x) % 1 else (x[len(x) // 2] + x[len(x) // 2 + 1]) / 2

original_array = [[55, 33, 250, 44],
                  [88, 1, 67, 23],
                  [199, 222, 38, 47],
                  [155, 145, 20, 99]]

# 1차원 배열로 바꿀 것
print('1차원 변경 후, 정렬 전 -->', array := sum(original_array, []))

insertion_sort(array)
print('1차원 변경 후, 정렬 후 -->', array)
print('중앙값 --> ', median(array))
