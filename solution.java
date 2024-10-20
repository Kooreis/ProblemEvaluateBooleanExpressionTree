Here is a simple Java console application that evaluates a boolean expression tree:

```java
import java.util.Stack;

abstract class Node {
    abstract boolean evaluate();
}

class ValueNode extends Node {
    private boolean value;

    public ValueNode(boolean value) {
        this.value = value;
    }

    @Override
    boolean evaluate() {
        return value;
    }
}

class OperatorNode extends Node {
    private char operator;
    private Node left;
    private Node right;

    public OperatorNode(char operator, Node left, Node right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    @Override
    boolean evaluate() {
        switch (operator) {
            case '&':
                return left.evaluate() && right.evaluate();
            case '|':
                return left.evaluate() || right.evaluate();
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Node tree = new OperatorNode('|',
                new OperatorNode('&', new ValueNode(true), new ValueNode(false)),
                new ValueNode(true)
        );

        System.out.println("Result: " + tree.evaluate());
    }
}
```

This program defines an abstract `Node` class with an `evaluate` method, and two subclasses `ValueNode` and `OperatorNode`. `ValueNode` represents a leaf node with a boolean value, and `OperatorNode` represents an internal node with an operator and two child nodes. The `evaluate` method of `OperatorNode` evaluates the boolean expression represented by the subtree rooted at the node, using the operator and the values of the child nodes. The `main` method creates a boolean expression tree and evaluates it.