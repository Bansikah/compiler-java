package org.example;

import org.example.lexer.Lexer;
import org.example.lexer.Token;
import org.example.parser.ASTNode;
import org.example.parser.Parser;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String sourceCode = "x + 5";

        Lexer lexer = new Lexer();
        List<Token> tokens = lexer.tokenize(sourceCode);

        Parser parser = new Parser(tokens);
        ASTNode ast = parser.parse();

        System.out.println("AST:");
        System.out.println(ast); // Assuming ASTNode has a toString method
    }
}
