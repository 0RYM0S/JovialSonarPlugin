package com.jovial.plugin;

import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.api.server.rule.RulesDefinition.NewRepository;

/**
 * Registers rule metadata so that issues can be linked to SonarQube rules.
 */
public class JovialRulesDefinition implements RulesDefinition {

    public static final String REPOSITORY_KEY = "jovial-repo";

    @Override
    public void define(Context context) {
        NewRepository repo = context
                .createRepository(REPOSITORY_KEY, JovialLanguage.KEY)
                .setName("Jovial Example Rules");

        repo.createRule("MaxLineLength")
                .setName("Limit character per line")
                .setHtmlDescription("Lines should stay short for readability.");

        repo.done();
    }
}