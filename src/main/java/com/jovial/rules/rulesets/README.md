This folder hosts example rule implementations used in the proof of concept.

Current rules:
- `NoGoto` flags any occurrence of the word "goto".
- `LongFunction` warns about functions longer than thirty lines.
- `BasicRuleset` registers the available rules with the `RuleRegistry`.

Additional rulesets can be added here in the future.
