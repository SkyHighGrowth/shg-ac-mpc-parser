package com.brandmaker.skyhigh.ac.mpcparser.controlers;

import com.shg.bmapi.configurations.properties.ConfigProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomePageController {

    private static final String HOME_TEMPLATE = "home";
    public static final String CONFIG_PROPERTIES = "configProperties";
    private final ConfigProperties properties;


    public HomePageController(ConfigProperties configProperties) {
        this.properties = configProperties;
    }

    @GetMapping("/config-page")
    public String homePage(Model model) {
        model.addAttribute(CONFIG_PROPERTIES, properties);
        return HOME_TEMPLATE;
    }

    @PostMapping("/updateConfigurationProperties")
    public String updateConfigurationProperties(@ModelAttribute ConfigProperties customConfigData, Model model) {
        properties.setUrl(customConfigData.getUrl());
        properties.setUsername(customConfigData.getUsername());
        properties.setPassword(customConfigData.getPassword());

        model.addAttribute(CONFIG_PROPERTIES, properties);

        return HOME_TEMPLATE;
    }
}
