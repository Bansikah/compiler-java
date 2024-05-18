package org.example.parser;


public class NumberNode extends ASTNode {
    private int value;

    public NumberNode(int value) {
        this.value = value;
    }

    @Override
    public String toTreeString(String indent) {
        return indent + value;
    }
}
