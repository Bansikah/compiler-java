package org.example.parser;

import org.example.lexer.Token;
import org.example.lexer.Token.TokenType;

import java.util.List;

public class Parser {

    private List<Token> tokens;
    private int currentTokenIndex = -1;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    public ASTNode parse() {
        currentTokenIndex = 0;
        return expression();
    }

    private ASTNode expression() {
        ASTNode left = term();
        while (match(TokenType.OPERATOR)) {
            String operator = previous().getValue();
            ASTNode right = term();
            left = new BinaryExprNode(left, operator, right); // Create binary expression node (optional)
        }
        return left;
    }

    private ASTNode term() {
        if (match(TokenType.NUMBER)) {
            return new NumberNode(Integer.parseInt(previous().getValue())); // Create number node (optional)
        } else if (match(TokenType.IDENTIFIER)) {
            String name = previous().getValue(); // Get the identifier name
            return new IdentifierNode(name); // Create and return an IdentifierNode
        } else {
            throw new RuntimeException("Unexpected token in term: " + peek().getValue());
        }
    }


    private boolean match(TokenType type) {
        if (peek() != null && peek().getType() == type) {
            consume();
            return true;
        }
        return false;
    }

    private Token peek() {
        if (currentTokenIndex >= tokens.size()) {
            return null;
        }
        return tokens.get(currentTokenIndex);
    }

    private Token previous() {
        if (currentTokenIndex - 1 < 0) {
            return null;
        }
        return tokens.get(currentTokenIndex - 1);
    }

    private void consume() {
        currentTokenIndex++;
    }
}
