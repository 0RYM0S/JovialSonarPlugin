package com.jovial.rules.base;

import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.issue.NewIssue;
import org.sonar.api.batch.sensor.issue.NewIssueLocation;
import org.sonar.api.rule.RuleKey;
import com.jovial.plugin.JovialRulesDefinition;

/**
 * Helper used by rules to report issues to SonarQube.
 */
public final class IssueReporter {
    private IssueReporter() {
    }

    public static void reportIssue(SensorContext context, InputFile file, int line, String ruleKey, String message) {
        RuleKey key = RuleKey.of(JovialRulesDefinition.REPOSITORY, ruleKey);
        NewIssue issue = context.newIssue().forRule(key);
        NewIssueLocation location = issue.newLocation().on(file).message(message);
        if (line > 0) {
            location.at(file.newRange(line, 0, line, 1));
        }
        issue.at(location);
        issue.save();
    }
}
