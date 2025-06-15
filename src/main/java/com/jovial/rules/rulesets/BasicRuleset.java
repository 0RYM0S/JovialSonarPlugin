package com.jovial.rules.rulesets;

import com.jovial.rules.base.Rule;
import com.jovial.rules.base.RuleRegistry;

/**
 * Convenience class to register all sample rules.
 */
public final class BasicRuleset {

    private BasicRuleset() {
    }

    public static void register(RuleRegistry registry) {
        registry.register(new NoGoto());
        registry.register(new LongFunction());
    }
}
