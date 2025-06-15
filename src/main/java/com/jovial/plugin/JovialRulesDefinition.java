package com.jovial.plugin;

import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.api.server.rule.RulesDefinition.NewRepository;

/**
 * Declares the rules that belong to the Jovial plugin.  Only a couple of
 * example rules are provided for the proof of concept.
 */
public class JovialRulesDefinition implements RulesDefinition {

    public static final String REPOSITORY_KEY = "jovial-repo";

    @Override
    public void define(Context context) {
        NewRepository repo = context.createRepository(REPOSITORY_KEY, JovialLanguage.KEY)
                .setName("Jovial Rules");

        repo.createRule("JOV001")
                .setName("Avoid GOTO")
                .setHtmlDescription("GOTO statements should be avoided");

        repo.createRule("JOV002")
                .setName("Long Function")
                .setHtmlDescription("Functions should not exceed thirty lines");

        repo.done();
    }
}
