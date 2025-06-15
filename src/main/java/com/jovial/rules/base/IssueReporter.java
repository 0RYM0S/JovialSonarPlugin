package com.jovial.rules.base;

import com.jovial.plugin.JovialRulesDefinition;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.issue.NewIssue;
import org.sonar.api.batch.sensor.issue.NewIssueLocation;
import org.sonar.api.rule.RuleKey;

/**
 * Helper used by rules to create issues in SonarQube.
 */
public final class IssueReporter {

    private IssueReporter() {
        // utility class
    }

    /**
     * Report a new issue to SonarQube.
     *
     * @param context  sensor context
     * @param file     source file
     * @param line     line where the issue occurs
     * @param message  description of the problem
     * @param ruleKey  key of the rule that was violated
     */
    public static void reportIssue(SensorContext context, InputFile file, int line, String message, String ruleKey) {
        RuleKey key = RuleKey.of(JovialRulesDefinition.REPOSITORY_KEY, ruleKey);
        NewIssue issue = context.newIssue().forRule(key);
        NewIssueLocation location = issue.newLocation()
                .on(file)
                .at(file.newRange(line, 0, line, 0))
                .message(message);
        issue.at(location);
        issue.save();
    }
}
