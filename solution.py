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