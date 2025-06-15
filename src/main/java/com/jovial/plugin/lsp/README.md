Contains the stub LSP runner used to communicate with the external Python
`jovialserver`. At the moment it only exposes a static `parseAST` method that
returns `null`.

Future work will implement a real LSP client here to obtain AST models for
analysis rules.
