package com.jovial.rules.base;

import com.jovial.rules.rulesets.BasicRuleset;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides access to all available rulesets.
 */
public final class RuleRegistry {

    private RuleRegistry() {
        // utility class
    }

    /**
     * Gather all rules from the different rulesets.
     */
    public static List<Rule> getAllRules() {
        List<Rule> rules = new ArrayList<>();
        rules.addAll(BasicRuleset.getRules());
        return rules;
    }
}
