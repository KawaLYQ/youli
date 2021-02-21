package com.kawa.youli.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcTemplateConfiguration {

    @Bean(name = "dataSource")
    public DataSource createDatasource(JdbcConfiguration jdbcConfiguration){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(jdbcConfiguration.getDriver());
        dataSource.setUrl(jdbcConfiguration.getUrl());
        dataSource.setUsername(jdbcConfiguration.getUsername());
        dataSource.setPassword(jdbcConfiguration.getPassword());
        return dataSource;
    }

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate createJdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }

}
