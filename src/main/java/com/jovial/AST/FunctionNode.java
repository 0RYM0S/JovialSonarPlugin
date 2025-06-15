package com.jovial.AST;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a function in the Jovial AST.
 *
 * <p>Only the name and list of statements are stored for now. In a complete
 * implementation additional information like parameters, return types and
 * source locations would be required.</p>
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

    public void addStatement(StatementNode stmt) {
        statements.add(stmt);
    }
}