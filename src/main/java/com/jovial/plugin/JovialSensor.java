package com.jovial.plugin;

import com.jovial.AST.ASTModel;
import com.jovial.plugin.lsp.LSPRunner;
import com.jovial.rules.base.Rule;
import com.jovial.rules.base.RuleRegistry;
import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.sensor.Sensor;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.SensorDescriptor;


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
            if (!file.filename().endsWith(".j73")) {
                return;
            }

            ASTModel ast = LSPRunner.parseAST(file);
            if (ast != null) {
                for (Rule rule : RuleRegistry.all()) {
                    rule.apply(ast, file, context);
                }
            }
        });
    }
}