package com.springboot.learnspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class currencyController {

    @Autowired
    private CurrencyConfiguration currencyConfiguration;
    @RequestMapping("/currency-config")
    public CurrencyConfiguration getConfigDetails(){
        return currencyConfiguration;
    }
}
