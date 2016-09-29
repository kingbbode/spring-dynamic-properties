package com.kingbbode.dynamic.properties.config;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * Created by YG-MAC on 2016. 9. 29..
 */
@Configuration
public class AppConfig {
    private static final String SERVER_FILE = "file:/data/dynamic";
    private static final String CLASSPATH_FILE = "classpath:dynamic";
    private static final String SUFFIX = ".properties";

    @Bean
    ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames(CLASSPATH_FILE, SERVER_FILE);
        messageSource.setCacheMillis(5000);

        return messageSource;
    }
    @Bean
    PropertiesConfiguration propertiesConfiguration() throws Exception {
        PropertiesConfiguration configuration;
        try {
            configuration = new PropertiesConfiguration(SERVER_FILE + SUFFIX);
        } catch (ConfigurationException e) {
            configuration = new PropertiesConfiguration(CLASSPATH_FILE + SUFFIX);
        }
        configuration.setReloadingStrategy(new FileChangedReloadingStrategy());

        return configuration;
    }
}
