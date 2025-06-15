Contains the SonarQube plugin entry points.

Implemented components:
- `JovialLanguage` declares basic language information.
- `JovialSensor` runs the example rules on `.j73` files.
- `JovialRulesDefinition` exposes rule metadata to SonarQube.

Future work includes connecting to an actual language server and
expanding the list of extensions.
