package com.jovial.rules.base;

import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.issue.NewIssue;
import org.sonar.api.batch.sensor.issue.NewIssueLocation;
import org.sonar.api.rule.RuleKey;

/**
 * Helper utility for creating issues in SonarQube.
 */
public final class IssueReporter {

    private IssueReporter() {
    }

    public static void reportIssue(SensorContext context, InputFile file,
                                   String ruleKey, int line, String message) {
        RuleKey key = RuleKey.of(com.jovial.plugin.JovialRulesDefinition.REPOSITORY_KEY, ruleKey);
        NewIssue issue = context.newIssue().forRule(key);
        NewIssueLocation location = issue.newLocation()
                .on(file)
                .message(message);
        if (line > 0) {
            location.at(file.newRange(line, 0, line, 0));
        }
        issue.at(location);
        issue.save();
    }
}
