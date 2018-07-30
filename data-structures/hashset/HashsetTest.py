import unittest

from Hashset import Hashset


class MyTestCase(unittest.TestCase):
    def setUp(self):
        self.hashset = Hashset()

    def test_contains(self):
        self.assertEqual(False, self.hashset.contains(5))
        self.hashset.add(5)
        self.assertEqual(True, self.hashset.contains(5))

    def test_size(self):
        self.assertEqual(0, self.hashset.length)
        self.hashset.add(1)
        self.assertEqual(1, self.hashset.length)

    def test_set_doesnt_count_duplicates(self):
        self.hashset.add(1)
        self.hashset.add(1)
        self.assertEqual(1, self.hashset.length)

    def test_playground(self):
        self.hashset.playground()






if __name__ == '__main__':
    unittest.main()
