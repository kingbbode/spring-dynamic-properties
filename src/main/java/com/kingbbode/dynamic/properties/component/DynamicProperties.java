package com.kingbbode.dynamic.properties.component;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by YG on 2016-09-28.
 */
@Component
public class DynamicProperties {
    private PropertiesConfiguration configuration;
    private FileChangedReloadingStrategy strategy;
    
    private static final String SERVER_FILE = "file:/data/dynamic.properties";
    private static final String CLASSPATH_FILE = "dynamic.properties";
    
    @PostConstruct
    private void init() {
        try {
            configuration = new PropertiesConfiguration(SERVER_FILE);
        } catch (ConfigurationException e) {
            try {
                configuration = new PropertiesConfiguration(CLASSPATH_FILE);
            } catch (ConfigurationException e1) {
                configuration = null;
            }
        }
        if(configuration != null){
            strategy = new FileChangedReloadingStrategy();
            configuration.setReloadingStrategy(strategy);
        }
    }
    
    public String getProperty(String key){
        return (String) configuration.getProperty(key);
    }
}
