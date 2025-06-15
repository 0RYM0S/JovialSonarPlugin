package com.jovial.rules.rulesets;

import com.jovial.rules.base.IssueReporter;
import com.jovial.rules.base.Rule;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.sensor.SensorContext;

import java.io.IOException;
import java.nio.file.Files;

/**
 * Reports an issue whenever a call to `print` is encountered.
 */
public class NoPrintDebug implements Rule {

    public static final String KEY = "JOV002";

    @Override
    public void apply(InputFile inputFile, SensorContext context) {
        try {
            int lineNumber = 1;
            for (String line : Files.readAllLines(inputFile.path())) {
                if (line.contains("print(")) {
                    IssueReporter.reportIssue(context, inputFile, lineNumber,
                            "Debug print statements should be removed", KEY);
                }
                lineNumber++;
            }
        } catch (IOException e) {
            // ignore in this proof of concept
        }
    }
}
