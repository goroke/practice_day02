class Graph:
    def __init__(self, size):
        self.max_name_length = 10
        self._size = size
        self._matrix = [[0] * size for _ in range(size)]
        self._names = None

    def dfs(self, start=None, behavior=None):
        """
        깊이 우선 탐색
        :param start: 시작 위치(없으면 처음 지점부터 시작합니다)
        :param behavior: 탐색하면서 할 작업(함수)
                         1개의 인수를 갖는 함수여야 합니다.
        :return: 탐색 결과 찾아낸 정점들
        """
        '''
        (시작 지점부터)
        1. 출발
        2. visited에 없는 경우만 함수 실행 후 visited 에 추가
        3.   다른 지점들 중 인접해있고, 안 들른 곳이 있으면 간다.
        3-1. 그런 곳이 없으면 못 간다.
        4.   갈 곳이 있으면 현 위치를 스택에 추가하고 다음으로 간다.
        4-1.   갈 곳이 없으면
        4-1-1. 스택에 아무것도 없으면 탐색을 마친다.
        4-1-2. 스택에 뭔가 있으면 스택에서 pop 한 곳으로 이동한다.
        '''
        # 1. 출발
        if not start:
            start = 0

        current = start
        visited = []
        stack = []

        while True:
            # 2.
            if current not in visited:
                visited.append(current)
                if behavior:
                    behavior(current)

            # 3.
            next = None
            for other_vertex in range(self._size):
                if self._matrix[current][other_vertex] and other_vertex not in visited:
                    next = other_vertex
                    break

            # 4.
            if next:
                stack.append(current)
                current = next
            else:
                if not stack:
                    break
                else:
                    current = stack.pop()

        return visited

    def name(self, *names):
        """
        그래프의 각 정점에 이름을 부여합니다.
        아무것도 넣지 않거나, 유효하지 않은 값을 넣으면 이름이 바뀌지 않습니다.
        :param names: 이름 목록
        :return: 현재 이름 목록
        """
        if len(names) == self._size:
            self._names = names

        self.max_name_length = max(len(name) for name in names) + 1

        return self._names

    def can_reach(self, target):
        """
        시작점에서  target 번의 정점까지 도달할 수 있는지 확인합니다.
        :param target: 도달 가능 여부를 확인할 정점의 번호
        :return: 도달 가능 여부
        """
        # dfs 탐색 코드 차용
        # 1. 출발
        current = 0
        visited = []
        stack = []

        while True:
            # 2.
            # 중간에 찾으면 바로 True 반환
            if current == target: return True

            if current not in visited:
                visited.append(current)

            # 3.
            next = None
            for other_vertex in range(self._size):
                if self._matrix[current][other_vertex] and other_vertex not in visited:
                    next = other_vertex
                    break

            # 4.
            if next:
                stack.append(current)
                current = next
            else:
                if not stack:
                    break
                else:
                    current = stack.pop()

        return False

    def __repr__(self):
        space = ' '*self.max_name_length
        ret = ''
        formatted_names = [f'%{self.max_name_length}s' % name for name in self._names]
        if self._names:
            ret = space + ' '.join(formatted_names) + '\n'

        for i, row in enumerate(self._matrix):
            if self._names:
                ret += formatted_names[i]
                ret += ' '.join(f'%{self.max_name_length}s' % str(col) for col in row) + '\n'
        return ret

    def connect(self, departure, destination, weight=1):
        self._matrix[departure][destination] = weight

    def disconnect(self, departure, destination):
        self._matrix[departure][destination] = 0

    @property
    def matrix(self):
        return self._matrix[:]


class UndirectedGraph(Graph):
    def connect(self, departure, destination, weight=1):
        super().connect(departure, destination, weight)
        self._matrix[destination][departure] = weight

    def disconnect(self, departure, destination):
        super().disconnect(departure, destination)
        self._matrix[destination][departure] = 0
