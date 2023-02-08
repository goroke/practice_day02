from graph import UndirectedGraph


def store_max(index):
    global max_stocks
    if stocks[max_stocks] < stocks[index]:
        max_stocks = index
    return max_stocks


names = ('GS25', 'CU', 'Seven11', 'MiniStop', 'Emart24')
stocks = (30, 60, 10, 90, 40)
max_stocks = 0

stores = UndirectedGraph(5)
stores.name(*names)

stores.connect(0, 1)
stores.connect(0, 2)
stores.connect(1, 2)
stores.connect(1, 3)
stores.connect(2, 3)
stores.connect(3, 4)

print('## 편의점 그래프 ##')
print(stores)

stores.dfs(behavior=store_max)

print(f'허니버터칩 최대 보유 편의점(개수) --> {names[max_stocks]} ( {stocks[max_stocks]} )')
