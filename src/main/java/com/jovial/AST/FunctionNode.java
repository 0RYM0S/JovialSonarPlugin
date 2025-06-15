package com.jovial.AST;

import java.util.ArrayList;
import java.util.List;

/**
 * Minimal representation of a function.
 * TODO: include parameters, return types and proper scoping.
 */
public class FunctionNode {
    private final String name;
    private final List<StatementNode> body = new ArrayList<>();

    public FunctionNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<StatementNode> getBody() {
        return body;
    }
}
