package com.jovial.AST;

/**
 * Represents a single statement in the AST.  Only the statement text and line
 * number are kept for the proof of concept.  When the real parser is
 * integrated this class should include the full node type, children and source
 * range information.
 */
public class StatementNode {

    private final String text;
    private final int line;

    public StatementNode(String text, int line) {
        this.text = text;
        this.line = line;
    }

    public String getText() {
        return text;
    }

    public int getLine() {
        return line;
    }
}
