package com.kingbbode.dynamic.properties.config;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by YG-MAC on 2016. 9. 29..
 */
@Configuration
public class AppConfig {
    private static final String SERVER_FILE = "file:/data/dynamic.properties";
    private static final String CLASSPATH_FILE = "dynamic.properties";

    @Bean
    PropertiesConfiguration propertiesConfiguration() throws Exception {
        PropertiesConfiguration configuration;
        try {
            configuration = new PropertiesConfiguration(SERVER_FILE);
        } catch (ConfigurationException e) {
            configuration = new PropertiesConfiguration(CLASSPATH_FILE);
        }
        configuration.setReloadingStrategy(new FileChangedReloadingStrategy());

        return configuration;
    }
}
