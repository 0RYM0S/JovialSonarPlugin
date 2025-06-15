package com.jovial.plugin;

import org.sonar.api.batch.sensor.Sensor;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.SensorDescriptor;
import org.sonar.api.batch.fs.FileSystem;


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
        fs.inputFiles(fs.predicates().all()).forEach(file -> {
            if (!file.filename().endsWith(".jov")) return;

//            ASTModel ast = LSPRunner.parseAST(file);
//            if (ast != null) {
//                NoGotoRule.apply(ast, file, context);
//                // Add more rule calls here...
//            }
        });
    }
}