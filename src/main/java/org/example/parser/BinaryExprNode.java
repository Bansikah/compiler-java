package  org.example.parser;

public class BinaryExprNode extends ASTNode {
    private ASTNode left;
    private String operator;
    private ASTNode right;

    public BinaryExprNode(ASTNode left, String operator, ASTNode right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override
    public String toTreeString(String indent) {
        return indent + operator + "\n" +
                left.toTreeString(indent + "  ") + "\n" +
                right.toTreeString(indent + "  ");
    }
}
