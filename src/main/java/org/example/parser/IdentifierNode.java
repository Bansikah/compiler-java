package org.example.parser;

import org.example.parser.ASTNode;

public class IdentifierNode extends ASTNode {
    private String name;

    public IdentifierNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toTreeString(String indent) {
        return indent + "Identifier: " + name;
    }
}
