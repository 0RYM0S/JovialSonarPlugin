# Jovial Sonar Plugin

This repository contains a minimal template for creating a custom language plugin for SonarQube. It defines a new language named **Jovial** and a simple sensor that demonstrates how rules can be executed on source files.

## Building

The project uses Maven. Run the following command to compile the code and execute tests:

```bash
mvn verify
```

The build requires Java 11 and uses JUnit 5 for testing.

## jovialserver

`JovialSensor` is designed to communicate with **jovialserver**, a Python
language server built with [pygls](https://github.com/openlawlibrary/pygls).
For the POC the language server is replaced with a simple file reader but the
integration points remain.

## Structure

- `JovialPlugin` registers plugin extensions.
- `JovialLanguage` declares the language key and file suffix.
- `JovialSensor` executes a few demonstration rules.
- `rules` package contains the example rule implementations.

Feel free to extend these classes with additional functionality.
