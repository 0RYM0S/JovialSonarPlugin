This package contains the main SonarQube plugin classes for the Jovial proof of
concept. `JovialPlugin` registers the language, sensor and rule definitions. The
sensor currently reads each `.j73` file, builds a trivial AST via `LSPRunner`
and executes the example rules from `rules`.

Future work includes integrating with the real Jovial language server and
expanding the set of rules and configuration options.
