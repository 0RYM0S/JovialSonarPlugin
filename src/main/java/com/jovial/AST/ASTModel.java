package com.jovial.AST;

import java.util.ArrayList;
import java.util.List;

/**
 * Very small AST model used for POC analysis.
 * <p>
 * TODO: replace this placeholder model with a full representation of the
 * language. Nodes should include proper relationships (parent/child,
 * expressions, types, etc.) and should be produced by a real parser or
 * language server.
 */
public class ASTModel {
    private final List<StatementNode> statements = new ArrayList<>();

    public List<StatementNode> getStatements() {
        return statements;
    }

    /**
     * Create a basic model from raw source lines.
     * Each line becomes a {@link StatementNode}.
     */
    public static ASTModel fromLines(List<String> lines) {
        ASTModel model = new ASTModel();
        for (int i = 0; i < lines.size(); i++) {
            model.statements.add(new StatementNode(i + 1, lines.get(i)));
        }
        return model;
    }
}
