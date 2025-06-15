package com.jovial.plugin;

import com.jovial.rules.base.RuleRegistry;
import org.sonar.api.Plugin;

public class JovialPlugin implements Plugin {
    @Override
    public void define(Context context) {
        context.addExtension(JovialLanguage.class);

        // JovialSensor performs analysis by talking to jovialserver (pygls based)
        context.addExtension(JovialSensor.class);

        context.addExtension(JovialRulesDefinition.class);
        RuleRegistry registry = new RuleRegistry();
        registry.registerAll();

    }
}
