package com.jovial.rules.rulesets;

import com.jovial.AST.ASTModel;
import com.jovial.AST.FunctionNode;
import com.jovial.rules.base.IssueReporter;
import com.jovial.rules.base.Rule;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.sensor.SensorContext;

/**
 * Flags functions that exceed a configurable number of statements.
 */
public class MaxStatementsPerFunction implements Rule {

    public static final String KEY = "MaxStatements";
    private final int maxStatements;

    public MaxStatementsPerFunction(int maxStatements) {
        this.maxStatements = maxStatements;
    }

    @Override
    public String key() {
        return KEY;
    }

    @Override
    public void apply(ASTModel ast, InputFile file, SensorContext context) {
        for (FunctionNode fn : ast.getFunctions()) {
            if (fn.getStatements().size() > maxStatements) {
                IssueReporter.reportIssue(context, file, KEY, 1,
                        "Function '" + fn.getName() + "' has more than " + maxStatements + " statements");
            }
        }
    }
}
