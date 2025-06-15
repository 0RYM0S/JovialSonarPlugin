package com.jovial.rules.base;

import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.sensor.SensorContext;

/**
 * Interface for simple analysis rules executed by {@link com.jovial.plugin.JovialSensor}.
 */
public interface Rule {

    /**
     * Apply the rule to the given source file.
     *
     * @param inputFile jovial source file
     * @param context sensor context to report issues
     */
    void apply(InputFile inputFile, SensorContext context);
}
