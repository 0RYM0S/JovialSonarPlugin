The `rules` package contains the base rule framework and a small set of example
rules used for demonstration. `base` defines simple abstractions for executing
rules and reporting issues. `rulesets` hosts concrete rule implementations such
as `NoGoto` and `MaxStatementsPerFunction`.

Additional production rules should be added here once the AST information from
the language server becomes richer.
