This package contains placeholder classes representing the AST returned by the
external Jovial language server. They are intentionally minimal and document
what still needs to be implemented.

* `ASTModel` - the root object for parsed files. Currently only a shell with
  TODOs for a real tree representation.
* `StatementNode` - generic statement placeholder.
* `FunctionNode` - placeholder for a function definition.

TODO:
- Flesh out the node hierarchy with proper fields and relations.
- Add parsing utilities once the LSP integration is ready.
