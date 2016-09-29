package com.kingbbode.dynamic.properties.controller;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

/**
 * Created by YG on 2016-09-29.
 */
@Controller
public class HomeController {

    @Autowired
    private ReloadableResourceBundleMessageSource messageSource;

    @Autowired
    private PropertiesConfiguration dynamicProperties;
    
    @RequestMapping(value = "/")
    public String home(Model model){
        //PropertiesConfiguration
        model.addAttribute("ApacheString", dynamicProperties.getString("dynamic.string"));
        model.addAttribute("ApacheInt", dynamicProperties.getInt("dynamic.int"));
        model.addAttribute("ApacheList", dynamicProperties.getList("dynamic.list"));

        //ReloadableResourceBundleMessageSource
        model.addAttribute("SpringString", messageSource.getMessage("dynamic.string", null , Locale.US));
        model.addAttribute("SpringInt", messageSource.getMessage("dynamic.int", null , Locale.US));
        model.addAttribute("SpringList", messageSource.getMessage("dynamic.list", null , Locale.US).split(","));
        return "home";
    }
}
