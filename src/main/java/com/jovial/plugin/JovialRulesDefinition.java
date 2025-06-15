package com.jovial.plugin;

import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.api.server.rule.RulesDefinition.NewRepository;

/**
 * Exposes the Jovial rules to SonarQube.
 */
public class JovialRulesDefinition implements RulesDefinition {
    public static final String REPOSITORY = "jovial";

    @Override
    public void define(Context context) {
        NewRepository repo = context.createRepository(REPOSITORY, JovialLanguage.KEY).setName("Jovial Rules");
        repo.createRule("JOV001").setName("Avoid GOTO").setHtmlDescription("GOTO statements should be avoided");
        repo.createRule("JOV002").setName("Line too long").setHtmlDescription("Lines should not exceed 120 characters");
        repo.done();
    }
}
