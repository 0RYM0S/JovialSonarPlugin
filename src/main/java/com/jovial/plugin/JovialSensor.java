package com.jovial.plugin;

import org.sonar.api.batch.sensor.Sensor;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.SensorDescriptor;
import com.jovial.AST.ASTModel;
import com.jovial.plugin.lsp.LSPRunner;
import com.jovial.rules.base.RuleRegistry;
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
        fs.inputFiles(fs.predicates().hasLanguage(JovialLanguage.KEY)).forEach(file -> {
            ASTModel ast = LSPRunner.parse(file);
            if (ast != null) {
                RuleRegistry.getRules().forEach(rule -> rule.apply(ast, file, context));
            }
        });
    }
}
