from data_structure import BinaryTree
import random

products = ['바나나맛우유', '레쓰비캔커피', '츄파춥스', '도시락', '삼다수', '코카콜라', '삼각김밥']
sold = [random.choice(products) for _ in range(20)]

if __name__ == "__main__":
    print(f'오늘 판매된 물건(중복O) --> {sold}')

    products_tree = BinaryTree()
    for item in sold:
        products_tree.add(item)

    print('오늘 판매된 종류(중복X)--> ', end=' ')

    # 이진 트리를 중위 순회하면 오름차순 정렬이 된다.
    for item in products_tree.inorder():
        print(item, end=' ')

    print()
