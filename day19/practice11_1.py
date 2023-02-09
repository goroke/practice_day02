def insertion_sort(array, keyidx=1):
    for i in range(1, len(array)):
        for j in range(i, 0, -1):
            if array[j][keyidx] < array[j-1][keyidx]:
                array[j], array[j-1] = array[j-1], array[j]


def make_pair(array):
    return [(array[i], array[-i-1]) for i in range(len(array) // 2)]


score_array = [['선미', 88], ['초아', 99], ['화사', 71], ['영탁', 78], ['영웅', 67], ['민호', 92]]

print(f'정렬 전 --> {score_array}')

insertion_sort(score_array)
print(f'정렬 후 --> {score_array}')
print('## 성적별 조 편성표 ##')

for pair in make_pair(score_array):
    print(f'{pair[0][0]} : {pair[1][0]}')
