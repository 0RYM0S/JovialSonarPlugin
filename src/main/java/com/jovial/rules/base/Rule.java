package com.jovial.rules.base;

import com.jovial.AST.ASTModel;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.sensor.SensorContext;

/**
 * Base interface for Jovial analysis rules.
 */
public interface Rule {
    /**
     * Unique key identifying the rule in the repository.
     */
    String key();

    /**
     * Apply the rule on the given AST and report issues through the context.
     */
    void apply(ASTModel ast, InputFile file, SensorContext context);
}
