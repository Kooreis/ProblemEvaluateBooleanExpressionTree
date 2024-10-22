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