package com.jovial.rules.base;

import com.jovial.AST.ASTModel;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.sensor.SensorContext;

/**
 * Base interface for all Jovial rules. Implementations examine the AST and
 * report issues through the provided {@link SensorContext}.
 */
public interface Rule {

    /**
     * Identifier of the rule as registered in {@link com.jovial.plugin.JovialRulesDefinition}.
     */
    String key();

    /**
     * Apply this rule to the given AST.
     */
    void apply(ASTModel ast, InputFile file, SensorContext context);
}
