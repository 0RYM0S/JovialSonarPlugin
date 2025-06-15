package com.jovial.rules.rulesets;

import com.jovial.rules.base.Rule;

import java.util.Arrays;
import java.util.List;

/**
 * Example ruleset bundling simple demo rules.
 */
public final class BasicRuleset {

    private BasicRuleset() {
    }

    public static List<Rule> getRules() {
        return Arrays.asList(
                new NoGoto(),
                new NoPrintDebug()
        );
    }
}
