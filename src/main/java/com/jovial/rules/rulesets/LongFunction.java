package com.jovial.rules.rulesets;

import com.jovial.AST.ASTModel;
import com.jovial.AST.FunctionNode;
import com.jovial.rules.base.IssueReporter;
import com.jovial.rules.base.Rule;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.sensor.SensorContext;

/**
 * Reports functions that exceed a hard coded length.
 */
public class LongFunction implements Rule {

    private static final int MAX_LINES = 30;

    @Override
    public String key() {
        return "JOV002";
    }

    @Override
    public void apply(ASTModel ast, InputFile file, SensorContext context) {
        for (FunctionNode fn : ast.getFunctions()) {
            if (fn.getStatements().size() > MAX_LINES) {
                IssueReporter.report(
                        context,
                        file,
                        key(),
                        fn.getStatements().get(MAX_LINES).getLine(),
                        "Function '" + fn.getName() + "' is too long");
            }
        }
    }
}
