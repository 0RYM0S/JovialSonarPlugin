package com.jovial.plugin;

import org.sonar.api.batch.sensor.Sensor;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.SensorDescriptor;
import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.batch.fs.InputFile;

import com.jovial.rules.base.Rule;
import com.jovial.rules.base.RuleRegistry;


public class JovialSensor implements Sensor {

    private final FileSystem fs;

    public JovialSensor(FileSystem fs) {
        this.fs = fs;
    }

    @Override
    public void describe(SensorDescriptor descriptor) {
            descriptor.name("Jovial Sensor").onlyOnLanguage(JovialLanguage.KEY);
    }

    @Override
    public void execute(SensorContext context) {
        fs.inputFiles(fs.predicates().hasLanguage(JovialLanguage.KEY)).forEach(file -> {
            for (Rule rule : RuleRegistry.getAllRules()) {
                rule.apply(file, context);
            }
        });
    }
}