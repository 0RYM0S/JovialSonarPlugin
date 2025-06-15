package com.jovial.rules.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Maintains the list of rules that will be executed by the sensor.
 */
public final class RuleRegistry {

    private static final List<Rule> RULES = new ArrayList<>();

    private RuleRegistry() {
    }

    public static void register(Rule rule) {
        RULES.add(rule);
    }

    public static List<Rule> all() {
        return Collections.unmodifiableList(RULES);
    }
}
