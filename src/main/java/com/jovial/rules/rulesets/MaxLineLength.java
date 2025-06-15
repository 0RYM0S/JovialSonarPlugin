package com.jovial.rules.rulesets;

import com.jovial.AST.ASTModel;
import com.jovial.AST.StatementNode;
import com.jovial.rules.base.IssueReporter;
import com.jovial.rules.base.Rule;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.sensor.SensorContext;

/**
 * Flags lines that exceed 120 characters.
 */
public class MaxLineLength implements Rule {
    private static final int MAX_LENGTH = 120;

    @Override
    public String key() {
        return "JOV002";
    }

    @Override
    public void apply(ASTModel ast, InputFile file, SensorContext context) {
        for (StatementNode stmt : ast.getStatements()) {
            if (stmt.getText().length() > MAX_LENGTH) {
                IssueReporter.reportIssue(context, file, stmt.getLine(), key(), "Line exceeds " + MAX_LENGTH + " characters");
            }
        }
    }
}
