class Node:
    def __init__(self, data=None):
        self.link = None
        self.data = data

    def __repr__(self):
        if self.data is None:
            return "(Empty Node)"
        else:
            return f"Node (data: {str(self.data)})"


class Queue:
    def __init__(self, size):
        self._size = size
        self._raw = [None] * size
        self._front = self._rear = -1

    def is_full(self):
        return self._rear - self._front == self._size

    def is_empty(self):
        return self._rear == self._front

    def shift(self):
        # 자료를 한 칸씩 왼쪽으로 옮긴다.
        if self._front == -1: return
        for idx in range(self._front + 1, self._size):
            self._raw[idx - 1] = self._raw[idx]
            self._raw[idx] = None

        self._front -= 1
        self._rear -= 1

    def enqueue(self, data):
        """
        큐에 데이터를 삽입합니다.
        :param data: 넣을 데이터
        :return: 성공 여부
        """
        # 가득 찬 경우는 데이터를 넣을 수 없다.
        if self.is_full():
            return False
        elif self._rear + 1 == self._size:
            self.shift()

        self._rear += 1
        self._raw[self._rear] = data
        return True

    def dequeue(self):
        """
        큐의 맨 앞에 있던 데이터 하나를 제거합니다.
        :return: 제거된 값(실패한 경우 None)
        """
        if self.is_empty():
            return None
        else:
            self._front += 1
            data = self._raw[self._front]
            self._raw[self._front] = None
            return data

    def peek(self):
        """
        큐의 맨 앞에 있는 데이터를 확인합니다.
        :return: 맨 앞에 있는 값(실패한 경우 None)
        """
        if self.is_empty():
            return None
        else:
            return self._raw[self._front + 1]

    def __repr__(self):
        return str(self._raw)


class CircularQueue(Queue):
    def __init__(self, size):
        super().__init__(size)
        self._front = self._rear = 0

    def is_full(self):
        return (self._rear + 1) % self._size == self._front

    # is_ empty 는 오버라이드할 필요가 없다.

    def enqueue(self, data):
        """
        큐에 데이터를 삽입합니다.
        :param data: 넣을 데이터
        :return: 성공 여부
        """
        # 가득 찬 경우는 데이터를 넣을 수 없다.
        if self.is_full():
            return False

        self._rear += 1
        self._rear %= self._size
        self._raw[self._rear] = data
        return True

    def dequeue(self):
        """
        큐의 맨 앞에 있던 데이터 하나를 제거합니다.
        :return: 제거된 값(실패한 경우 None)
        """
        if self.is_empty():
            return None
        else:
            self._front += 1
            self._front %= self._size
            data = self._raw[self._front]
            self._raw[self._front] = None
            return data

    def peek(self):
        """
        큐의 맨 앞에 있는 데이터를 확인합니다.
        :return: 맨 앞에 있는 값(실패한 경우 None)
        """
        if self.is_empty():
            return None
        else:
            return self._raw[(self._front + 1) % self._size]


class BinaryNode(Node):
    def __init__(self, data=None):
        super().__init__(data)
        self.left = None
        self.right = None
        del self.link


class BinaryTree:
    def __init__(self, root: BinaryNode = None):
        self._root = root

    def add(self, node):
        """
        이진 트리에 값을 추가합니다.
        :param node: 추가할 노드 혹은 값
        :return: 성공 여부
        """
        # 입력 값이 노드가 아니라면, 입력 값을 가진 노드를 만들어서 추가한다.
        if type(node) != BinaryNode:
            node = BinaryNode(node)

        # 루트가 없으면 추가한다.
        if self._root is None:
            self._root = node
            return True
        
        current = self._root
        while True:
            # 기존 노드보다 더 큰 값을 가졌으면 오른쪽으로 보낸다.
            if node.data > current.data:
                if current.right:
                    current = current.right
                    continue
                else:
                    current.right = node
                    return True

            # 기존 노드보다 더 작은 값을 가졌으면 왼쪽으로 보낸다.
            elif node.data < current.data:
                if current.left:
                    current = current.left
                    continue
                else:
                    current.left = node
                    return True

            else:
                return False

    def preorder(self, node=None):
        if node is None: node = self._root
        return_list = []

        def inner_process(current_node):
            nonlocal return_list
            return_list.append(current_node.data)
            if current_node.left: inner_process(current_node.left)
            if current_node.right: inner_process(current_node.right)

        inner_process(node)
        return return_list

    def inorder(self, node=None):
        if node is None: node = self._root
        return_list = []

        def inner_process():
            nonlocal return_list
            if node.left: inner_process(node.left)
            return_list.append(node.data)
            if node.right: inner_process(node.right)

        return return_list

    def postorder(self, node=None):
        if node is None: node = self._root
        return_list = []

        def inner_process():
            nonlocal return_list
            if node.left: inner_process(node.left)
            if node.right: inner_process(node.right)
            return_list.append(node.data)

        return return_list
