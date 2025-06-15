package com.jovial.AST;

/**
 * Minimal representation of an Abstract Syntax Tree produced by the external
 * language server. Only the structure required by demonstration rules is
 * modelled here.
 *
 * TODO: replace this with a full fledged model once the real parser is
 * available. The actual implementation should provide a tree of nodes with
 * parents/children and rich type information.
 */
public class ASTModel {
    public StatementNode[] getStatements() {
        return null;
    }

    public void addFunction(FunctionNode fn) {
    }
    // TODO: store root node and helper methods for traversal
}