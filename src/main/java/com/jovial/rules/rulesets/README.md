Example rules implemented for the proof of concept plugin.

- `NoGoto` reports any usage of a `goto` statement.
- `NoPrintDebug` flags occurrences of `print()` used for debugging.
- `BasicRuleset` exposes both rules so that the sensor can execute them.

Additional rulesets can be added here as the AST model evolves.
