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