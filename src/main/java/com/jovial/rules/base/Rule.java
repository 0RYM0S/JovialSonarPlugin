package com.jovial.rules.base;

import com.jovial.AST.ASTModel;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.sensor.SensorContext;

/**
 * Interface for simple analysis rules executed by {@link com.jovial.plugin.JovialSensor}.
 */
public interface Rule {



    String key();


    /**
     * Apply the rule to the given source file.
     *
     * @param inputFile jovial source file
     * @param context   sensor context to report issues
     */
    void apply(ASTModel ast, InputFile inputFile, SensorContext context);
}