package com.bqniu.capdemo.core.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties(prefix = "newpwr.cap")
public class CapConfig {
    //private CapDataSourcePropeties[] datasources;
    private CapMessageBusProperties[] mqs;
}
