package com.automationbytarun.properties;

import com.automationbytarun.ConfigurationException;

import static com.automationbytarun.properties.PropertiesLoader.*;

public class PropertiesValidator {


    public static void validateConfiguration() throws Exception {

        if (runOnBrowser.equalsIgnoreCase("Chrome")) {
            if (chromeDriverPath.isEmpty()) {
                throw new ConfigurationException("ChromeDriverPath empty");
            }
        }
        if (runOnBrowser.equalsIgnoreCase("Firefox")) {
            if (firefoxDriverPath.isEmpty()) {
                throw new ConfigurationException("FirefoxDriverPath empty");
            }
            if (runOnBrowser.equalsIgnoreCase("Edge")) {
                if (edgeDriverPath.isEmpty()) {
                    throw new ConfigurationException("EdgeDriverPath empty");

                }
            }
        }
    }
}

