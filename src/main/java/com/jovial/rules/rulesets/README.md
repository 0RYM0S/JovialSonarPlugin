Example rule implementations. At the moment two simple rules are available:
`NoGoto` warns whenever a statement contains the word "goto" and
`MaxStatementsPerFunction` checks for overly long functions. More sophisticated
rules can be added here once a real AST is available.
