package com.floris.antler;

import java.util.HashMap;

public class ConfigurationReader extends ConfigurationBaseListener {
    private HashMap<String, String> properties = new HashMap<>();

    @Override
    public void exitProperty(ConfigurationParser.PropertyContext ctx) {
        properties.put(ctx.getChild(0).getText(), ctx.getChild(2).getText());
    }

    public HashMap<String, String> getProperties() {
        return properties;
    }
}