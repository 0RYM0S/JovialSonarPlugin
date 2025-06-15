package com.jovial.rules.base;

import com.jovial.rules.rulesets.MaxLineLength;
import com.jovial.rules.rulesets.NoGoto;
import java.util.Arrays;
import java.util.List;

/**
 * Stores all rules that should be executed by the sensor.
 */
public final class RuleRegistry {
    private RuleRegistry() {
    }

    private static final List<Rule> RULES = Arrays.asList(
            new NoGoto(),
            new MaxLineLength()
    );

    public static List<Rule> getRules() {
        return RULES;
    }
}
