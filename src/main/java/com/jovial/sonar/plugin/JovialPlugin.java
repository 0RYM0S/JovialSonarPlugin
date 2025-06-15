package com.jovial.sonar.plugin;

import org.sonar.api.Plugin;

public class JovialPlugin implements Plugin {
    @Override
    public void define(Context context) {
        context.addExtension(JovialLanguage.class);
        // JovialSensor performs analysis by talking to jovialserver (pygls based)
        context.addExtension(JovialSensor.class);
    }
}
