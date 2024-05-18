package org.example.lexer;

import java.util.ArrayList;
import java.util.List;

public class Lexer {

    public List<Token> tokenize(String sourceCode) {
        List<Token> tokens = new ArrayList<>();
        char[] chars = sourceCode.toCharArray();
        int i = 0;
        while (i < chars.length) {
            char ch = chars[i];
            if (Character.isDigit(ch)) {
                // Extract number
                StringBuilder number = new StringBuilder();
                while (i < chars.length && Character.isDigit(chars[i])) {
                    number.append(ch);
                    i++;
                }
                tokens.add(new Token(Token.TokenType.NUMBER, number.toString()));
            } else if (Character.isLetter(ch)) {
                // Extract identifier
                StringBuilder identifier = new StringBuilder();
                while (i < chars.length && (Character.isLetterOrDigit(ch) || ch == '_')) {
                    identifier.append(ch);
                    i++;
                }
                tokens.add(new Token(Token.TokenType.IDENTIFIER, identifier.toString()));
            } else if (ch == '+' || ch == '-' || ch == '*') {
                tokens.add(new Token(Token.TokenType.OPERATOR, String.valueOf(ch)));
                i++;
            } else if (Character.isWhitespace(ch)) {
                // Skip whitespace
                i++;
            } else {
                // Handle errors (unexpected characters)
                throw new RuntimeException("Unexpected character: " + ch);
            }
        }
        return tokens;
    }
}
