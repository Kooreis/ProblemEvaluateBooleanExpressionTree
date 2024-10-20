Here is a Python console application that evaluates a boolean expression tree:

```python
class Node:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right

def evaluate(root):
    if root is None:
        return True

    if root.value == 'AND':
        return evaluate(root.left) and evaluate(root.right)

    if root.value == 'OR':
        return evaluate(root.left) or evaluate(root.right)

    if root.value == 'NOT':
        return not evaluate(root.left)

    return root.value

def main():
    # Constructing an expression tree:
    # ((True AND False) OR NOT(False))
    root = Node('OR', 
                Node('AND', 
                     Node(True), 
                     Node(False)), 
                Node('NOT', 
                     Node(False)))

    print(evaluate(root))

if __name__ == "__main__":
    main()
```

This program constructs a boolean expression tree and evaluates it. The `Node` class represents a node in the expression tree. It has a `value` which can be a boolean value or an operator ('AND', 'OR', 'NOT'), and `left` and `right` pointers to the left and right child nodes. The `evaluate` function recursively evaluates the expression tree. If the node's value is an operator, it applies the operator to the results of evaluating the left and right child nodes. If the node's value is a boolean value, it returns the value. The `main` function constructs an expression tree and prints the result of evaluating it.