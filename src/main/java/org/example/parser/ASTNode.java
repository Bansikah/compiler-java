package  org.example.parser;
public abstract class ASTNode {
    public abstract String toTreeString(String indent);

    @Override
    public String toString() {
        return toTreeString("");
    }
}