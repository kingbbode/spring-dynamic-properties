package com.kingbbode.dynamic.properties.controller;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by YG on 2016-09-29.
 */
@Controller
public class HomeController {
    
    @Autowired
    private PropertiesConfiguration dynamicProperties;
    
    @RequestMapping(value = "/")
    public String home(Model model){
        model.addAttribute("string", dynamicProperties.getString("dynamic.string"));
        model.addAttribute("int", dynamicProperties.getInt("dynamic.int"));
        model.addAttribute("list", dynamicProperties.getList("dynamic.list"));
        return "home";
    }
}
