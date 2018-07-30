class Hashset():

    def __init__(self):
        self.capacity = 8
        self.elements = [[] for _ in range(self.capacity)]
        self.length = 0

    def add(self, item):
        if self.contains(item):
            # Ignoring item, since it is already in set
            return

        itemHash = self.hashByCapacity(item)
        self.elements[itemHash].append(item)
        self.length = self.length + 1

    def contains(self, item):
        itemHash = self.hashByCapacity(item)
        return item in self.elements[itemHash]

    def hashByCapacity(self, item):
        return hash(item) % self.capacity

    def playground(self):
        for i in range(10):
            print(str(i) + " " + str(i * i))

        i = 0
        while i < 10:
            print(str(i) + " " + str(i * i))
            i += 1
