class Node:
    def __init__(self, data=None):
        self.link = None
        self.data = data

    def __repr__(self):
        if self.data is None:
            return "(Empty Node)"
        else:
            return str(self.data)


class DoubleLinkedNode(Node):
    def __init__(self, data=None):
        self.prev = None
        self.next = None
        self.data = data
