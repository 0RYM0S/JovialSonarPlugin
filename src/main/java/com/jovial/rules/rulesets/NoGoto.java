package com.jovial.rules.rulesets;

import com.jovial.AST.ASTModel;
import com.jovial.AST.FunctionNode;
import com.jovial.AST.StatementNode;
import com.jovial.rules.base.IssueReporter;
import com.jovial.rules.base.Rule;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.sensor.SensorContext;

/**
 * Example rule that simply flags any statement containing the word "goto".
 */
public class NoGoto implements Rule {

    public static final String KEY = "NoGoto";

    @Override
    public String key() {
        return KEY;
    }

    @Override
    public void apply(ASTModel ast, InputFile file, SensorContext context) {
        for (FunctionNode fn : ast.getFunctions()) {
            int line = 1;
            for (StatementNode stmt : fn.getStatements()) {
                if (stmt.getText().toLowerCase().contains("goto")) {
                    IssueReporter.reportIssue(context, file, KEY, line,
                        "Avoid using GOTO statements");
                }
                line++;
            }
        }
    }
}
