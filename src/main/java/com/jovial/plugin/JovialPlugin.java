package com.jovial.plugin;

import org.sonar.api.Plugin;

public class JovialPlugin implements Plugin {
    @Override
    public void define(Context context) {
        context.addExtension(JovialLanguage.class);
        // JovialSensor performs analysis by talking to jovialserver (pygls based)
        context.addExtension(JovialSensor.class);
        context.addExtension(JovialRulesDefinition.class);

        // register example rules for the proof of concept
        com.jovial.rules.base.RuleRegistry.register(new com.jovial.rules.rulesets.NoGoto());
        com.jovial.rules.base.RuleRegistry.register(new com.jovial.rules.rulesets.MaxStatementsPerFunction(20));
    }
}
