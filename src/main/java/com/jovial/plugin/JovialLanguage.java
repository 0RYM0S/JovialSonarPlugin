package com.jovial.plugin;

import org.sonar.api.resources.Language;

public class JovialLanguage implements Language {
    public static final String KEY = "jovial";
    public static final String NAME = "Jovial";

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String[] getFileSuffixes() {
        return new String[]{".j73"};
    }
}
