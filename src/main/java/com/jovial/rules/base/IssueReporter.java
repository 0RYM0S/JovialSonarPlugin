package com.jovial.rules.base;

import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.rule.RuleKey;

/**
 * Helper utility for creating issues in SonarQube.
 */
public final class IssueReporter {

    private IssueReporter() {
    }

    public static void report(SensorContext context, InputFile file, String ruleKey, int line, String message) {
        RuleKey key = RuleKey.of("jovial-repo", ruleKey);
        context.newIssue()
                .forRule(key)
                .at(context.newIssueLocation()
                        .on(file)
                        .at(file.newRange(line, 0, line, 0))
                        .message(message))
                .save();
    }
}
