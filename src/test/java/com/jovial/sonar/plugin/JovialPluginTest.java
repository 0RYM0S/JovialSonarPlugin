package com.jovial.sonar.plugin;

import com.jovial.plugin.JovialPlugin;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JovialPluginTest {
    @Test
    public void testPluginDefinition() {
        JovialPlugin plugin = new JovialPlugin();
        assertDoesNotThrow(() -> plugin.define(context -> {}));
    }
}
