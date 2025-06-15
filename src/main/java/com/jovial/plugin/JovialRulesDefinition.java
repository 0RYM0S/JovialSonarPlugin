package com.jovial.plugin;

import org.sonar.api.rules.RuleType;
import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.api.server.rule.RulesDefinition.NewRepository;

/**
 * Minimal rules definition registering a couple of example rules. The messages
 * for these rules are stored under resources in a JSON file.
 */
public class JovialRulesDefinition implements RulesDefinition {

    /** Repository key under which Jovial rules are registered. */
    public static final String REPOSITORY_KEY = "jovial";

    @Override
    public void define(Context context) {
        NewRepository repo = context.createRepository(REPOSITORY_KEY, JovialLanguage.KEY)
                .setName("Jovial Rules");

        repo.createRule("JOV001")
                .setName("Avoid GOTO")
                .setHtmlDescription("GOTO statements should be avoided.")
                .setType(RuleType.CODE_SMELL);

        repo.createRule("JOV002")
                .setName("No debug print")
                .setHtmlDescription("Debug print statements should be removed.")
                .setType(RuleType.CODE_SMELL);

        repo.done();
    }
}
