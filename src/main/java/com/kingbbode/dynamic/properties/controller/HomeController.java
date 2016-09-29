package com.kingbbode.dynamic.properties.controller;

import com.kingbbode.dynamic.properties.component.DynamicProperties;
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
    private DynamicProperties dynamicProperties;
    
    @RequestMapping(value = "/")
    public String home(Model model){
        model.addAttribute("dynamic", dynamicProperties.getProperty("dynamic"));
        return "home";
    }
}
