package com.jovial.AST;

/**
 * Represents a single statement in the AST. This is intentionally very light
 * weight for the POC and only provides a placeholder structure.
 *
 * TODO: add fields describing the type of statement, its text range and
 * potential child statements.
 */
public class StatementNode {
    public StatementNode(String line, int lineNo) {

    }

    public String getText() {
        return null;
    }

    public int getLine() {
        return 0;
    }
    // TODO: fields such as "type" and list of children
}