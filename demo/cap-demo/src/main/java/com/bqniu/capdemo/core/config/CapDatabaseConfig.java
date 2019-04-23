package com.bqniu.capdemo.core.config;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class CapDatabaseConfig {

    @Bean
    private Configuration configDatabase(){
        Configuration cfg = new Configuration().configure();
        return  cfg;
    }

    @Bean
    private SchemaExport configSchemExport(){
        SchemaExport export = new SchemaExport();
        return  export;
    }
}
