# Jovial Sonar Plugin

This repository contains a minimal template for creating a custom language plugin for SonarQube. It defines a new language named **Jovial** and a stub sensor that can be extended with real analysis logic.

## Building

The project uses Maven. Run the following command to compile the code and execute tests:

```bash
mvn verify
```

The build requires Java 11 and uses JUnit 5 for testing.

## jovialserver

`JovialSensor` is designed to communicate with **jovialserver**, a Python
language server built with [pygls](https://github.com/openlawlibrary/pygls).
The server is expected to run locally, and the sensor currently contains a
placeholder connection block where analysis requests would be sent.

## Structure

- `JovialPlugin` registers plugin extensions.
- `JovialLanguage` declares the language key and file suffix.
- `JovialSensor` is a placeholder sensor for analysis implementation.

Feel free to extend these classes with additional functionality.
