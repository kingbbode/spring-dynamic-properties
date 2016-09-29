package com.kingbbode.dynamic.properties.component;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YG on 2016-09-28.
 */
@Component
public class DynamicProperties {
    private static final Logger logger = LoggerFactory.getLogger(DynamicProperties.class);
    
    private PropertiesConfiguration configuration;
    private FileChangedReloadingStrategy strategy;
    
    private static final String DEV = "admin.dev";
    private static final String LOGIN = "admin.login";
    private static final int NAME = 0;
    private static final int EMAIL = 1;
    
    @PostConstruct
    private void init() {
        try {
            configuration = new PropertiesConfiguration("file:/data/dynamic.properties");            
        } catch (ConfigurationException e) {
            try {
                configuration = new PropertiesConfiguration("dynamic.properties");
            } catch (ConfigurationException e1) {
                configuration = null;
            }
        }
        if(configuration != null){
            strategy = new FileChangedReloadingStrategy();
            strategy.setRefreshDelay(1000*60*60*24*30);
            configuration.setReloadingStrategy(strategy);
        }
    }
    
    public String getProperty(String key){
        return (String) configuration.getProperty(key);
    }
}
