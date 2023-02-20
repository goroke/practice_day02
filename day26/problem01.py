from random import choices


def search(data: list, find: str, start=None, end=None):
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
        return search(data, find, mid+1, end)

    # 작은 경우
    else:
        return search(data, find, start, mid-1)


products_list = '도시락', '레쓰비캔커피', '바나나맛우유', '삼각김밥', '츄파춥스', '코카콜라'
products = choices(products_list, k=20)

print('#오늘 판매된 전체 물건(중복O, 정렬X) -->', products)

# 정렬
products.sort()
print('#오늘 판매된 전체 물건(중복O, 정렬O) -->', products)

# 중복 제거 및 결산 데이터 집계
idx = 0
cnt = 1
result = []
while idx < len(products):
    # 찾은 경우는 삭제(내 위치까지는 탐색할 필요가 없으므로 다음 칸부터 찾는다)
    if search(products, item := products[idx], idx+1) != -1:
        cnt += 1
        products.pop(idx)

    # 못 찾은 경우는 개수를 등록하고 다음으로 넘어갈 것
    else:
        result.append((item, cnt))
        idx += 1
        cnt = 1

print('#오늘 판매된 물품 종류(중복x) -->', products, '\n'
      '결산 결과 ==>', result)
