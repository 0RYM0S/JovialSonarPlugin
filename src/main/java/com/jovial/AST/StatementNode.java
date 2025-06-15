package com.jovial.AST;

/**
 * Represents a single line of source code.
 * TODO: expand with child nodes and token information once a real parser is integrated.
 */
public class StatementNode {
    private final int line;
    private final String text;

    public StatementNode(int line, String text) {
        this.line = line;
        this.text = text;
    }

    public int getLine() {
        return line;
    }

    public String getText() {
        return text;
    }
}
