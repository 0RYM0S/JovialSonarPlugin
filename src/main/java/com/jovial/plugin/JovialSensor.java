package com.jovial.plugin;

import com.jovial.AST.ASTModel;
import com.jovial.plugin.lsp.LSPRunner;
import com.jovial.rules.base.RuleRegistry;
import com.jovial.rules.rulesets.BasicRuleset;
import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.sensor.Sensor;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.SensorDescriptor;


public class JovialSensor implements Sensor {

    private final FileSystem fs;
    private final RuleRegistry registry = new RuleRegistry();

    public JovialSensor(FileSystem fs) {
        this.fs = fs;
        BasicRuleset.register(registry);
    }

    @Override
    public void describe(SensorDescriptor descriptor) {
            descriptor.name("Jovial Sensor").onlyOnLanguage(JovialLanguage.KEY);
    }

    @Override
    public void execute(SensorContext context) {
        fs.inputFiles(fs.predicates().hasLanguage(JovialLanguage.KEY)).forEach(file -> {
            ASTModel ast = LSPRunner.parseAST(file.file());
            registry.execute(ast, file, context);
        });
    }
}