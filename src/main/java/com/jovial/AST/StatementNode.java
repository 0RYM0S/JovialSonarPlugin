package com.jovial.AST;

/**
 * Minimal representation of a single statement in the AST. At this stage it
 * only stores the raw text of the statement.  Future revisions should expose
 * the actual structure of the statement (type, children, etc.) once a real
 * parser is implemented.
 */
public class StatementNode {

    /** Raw statement text extracted from the source file. */
    private final String text;

    public StatementNode(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    // TODO: replace this class with a rich representation produced by the
    // language server. The final version should include the kind of statement,
    // source code position and potentially child nodes for complex constructs.
}
