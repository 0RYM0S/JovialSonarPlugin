This package holds the SonarQube plugin implementation for the Jovial language.

Implemented components:
- `JovialLanguage` declares the language key and suffix.
- `JovialSensor` parses files using `LSPRunner` and executes registered rules.
- `JovialRulesDefinition` exposes a couple of example rules to SonarQube.

Remaining work includes integrating the real language server and fleshing out additional sensors and rules.
