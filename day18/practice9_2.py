from graph import UndirectedGraph
from operator import itemgetter

# 초기 값 설정
names = 'Seoul', 'New York', 'London', 'Beijing', 'Bangkok', 'Paris'
cities_count = len(names)

cables = UndirectedGraph(6)
cables.name(*names)

cables.connect(0, 1, 80)  # 서울, 뉴욕
cables.connect(0, 3, 10)  # 서울, 북경
cables.connect(1, 3, 40)  # 뉴욕, 북경
cables.connect(1, 4, 70)  # 뉴욕, 방콕
cables.connect(2, 4, 30)  # 런던, 방콕
cables.connect(2, 5, 60)  # 런던, 파리
cables.connect(3, 4, 50)  # 북경, 방콕
cables.connect(4, 5, 20)  # 방콕, 파리

# 출력
print('## 해저 케이블 연결을 위한 전체 연결도 ##')
print(cables)

# 정렬
cable_matrix = cables.matrix
edges = []
for row in range(cities_count):
    for col in range(row+1, cities_count):
        if cable_matrix[row][col]:
            edges.append((cable_matrix[row][col], row, col))

edges.sort(key=itemgetter(0), reverse=True)

# 최적화를 위한 크루스컬 알고리즘 실행
idx = len(edges) - 1
while len(edges) > cities_count - 1:
    speed, city1, city2 = edges[idx]

    # 일단 한 번 끊어본다.
    cables.disconnect(city1, city2)

    # 문제 없으면 끊어진 상태를 유지한다.
    if cables.can_reach(city1) and cables.can_reach(city2):
        edges.pop()

    # 문제 있으면 다시 잇는다.
    else:
        cables.connect(city1, city2, speed)

    idx -= 1

# 결과
print('## 가장 효율적인 해저 케이블 연결도 ##')
print(cables)
