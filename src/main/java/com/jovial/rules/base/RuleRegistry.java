package com.jovial.rules.base;

import com.jovial.AST.ASTModel;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.sensor.SensorContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Container for all registered rules that should run for the analysis.
 */
public class RuleRegistry {

    private final List<Rule> rules = new ArrayList<>();

    public void register(Rule rule) {
        rules.add(rule);
    }

    public void execute(ASTModel ast, InputFile file, SensorContext context) {
        for (Rule rule : rules) {
            rule.apply(ast, file, context);
        }
    }

    public void registerAll() {

    }
}