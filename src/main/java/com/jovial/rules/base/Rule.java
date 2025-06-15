package com.jovial.rules.base;

import com.jovial.AST.ASTModel;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.sensor.SensorContext;

/**
 * Contract implemented by all Jovial rules.
 */
public interface Rule {
    String key();

    void apply(ASTModel ast, InputFile file, SensorContext context);
}
