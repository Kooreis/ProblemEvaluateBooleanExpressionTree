```C#
using System;
using System.Collections.Generic;

public abstract class Node
{
    public abstract bool Evaluate();
}

public class AndNode : Node
{
    private Node left;
    private Node right;

    public AndNode(Node left, Node right)
    {
        this.left = left;
        this.right = right;
    }

    public override bool Evaluate()
    {
        return left.Evaluate() && right.Evaluate();
    }
}

public class OrNode : Node
{
    private Node left;
    private Node right;

    public OrNode(Node left, Node right)
    {
        this.left = left;
        this.right = right;
    }

    public override bool Evaluate()
    {
        return left.Evaluate() || right.Evaluate();
    }
}

public class NotNode : Node
{
    private Node node;

    public NotNode(Node node)
    {
        this.node = node;
    }

    public override bool Evaluate()
    {
        return !node.Evaluate();
    }
}

public class ValueNode : Node
{
    private bool value;

    public ValueNode(bool value)
    {
        this.value = value;
    }

    public override bool Evaluate()
    {
        return value;
    }
}

class Program
{
    static void Main(string[] args)
    {
        Node tree = new AndNode(
            new OrNode(
                new ValueNode(true),
                new ValueNode(false)
            ),
            new NotNode(
                new ValueNode(false)
            )
        );

        Console.WriteLine(tree.Evaluate());
    }
}
```