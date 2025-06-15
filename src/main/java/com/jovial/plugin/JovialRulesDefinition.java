package com.jovial.plugin;

import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.api.server.rule.RulesDefinition.NewRepository;

/**
 * Registers rule metadata so that issues can be linked to SonarQube rules.
 */
public class JovialRulesDefinition implements RulesDefinition {

    public static final String REPOSITORY_KEY = "jovial-rules";

    @Override
    public void define(Context context) {
        NewRepository repo = context
                .createRepository(REPOSITORY_KEY, JovialLanguage.KEY)
                .setName("Jovial Example Rules");

        repo.createRule("NoGoto")
                .setName("Avoid GOTO statements")
                .setHtmlDescription("GOTO statements make code harder to follow.");

        repo.createRule("MaxStatements")
                .setName("Limit statements per function")
                .setHtmlDescription("Functions should stay short for readability.");

        repo.done();
    }
}
