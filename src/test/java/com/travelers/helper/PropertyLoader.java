package com.travelers.helper;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class PropertyLoader {

    private static Configuration loadProperties() throws ConfigurationException {

        Configurations configs = new Configurations();
        return  configs.properties("src//main//resources//test.properties");
    }

    public static void main(String[] args) throws ConfigurationException {
        Configuration config = loadProperties();
        System.out.println(config.getString("driver"));
    }
}
