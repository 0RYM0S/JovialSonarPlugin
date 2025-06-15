package com.jovial.AST;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Jovial function in the AST. For the proof of concept we only
 * store the function name and a list of {@link StatementNode}s. The language
 * server should eventually provide precise type and position information.
 */
public class FunctionNode {

    private final String name;
    private final List<StatementNode> statements = new ArrayList<>();

    public FunctionNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<StatementNode> getStatements() {
        return statements;
    }

    /**
     * Adds a statement to this function node.
     */
    public void addStatement(StatementNode node) {
        statements.add(node);
    }

    // TODO: integrate with the real AST produced by the language server.
    // This placeholder only supports flat lists of statements and lacks
    // position information.
}
