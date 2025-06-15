This package contains the main SonarQube plugin classes for Jovial.

Implemented components:
- `JovialPlugin` registers the language and sensor.
- `JovialLanguage` declares language key and suffix.
- `JovialSensor` executes all registered rules on Jovial files.
- `JovialRulesDefinition` exposes two demo rules.

What's left:
- Extend `JovialSensor` to communicate with the real language server via
  `LSPRunner`.
- Add more sophisticated rules and corresponding unit tests.
