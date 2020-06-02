package com.pluralsight.conferencedemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String userPwd;

    // example of how to override default datasource construction (if needed),
    // otherwise it's wired by spring auto configuration
    @Bean
    public DataSource dataSource() {

        System.out.println(
                String.format("Building custom datasource: dbUrl = %s, uname = %s, pwd = %s",
                        dbUrl, userName, userPwd));

        DataSourceBuilder builder = DataSourceBuilder
                .create()
                .url(dbUrl)
                .username(userName)
                .password(userPwd);

        return builder.build();
    }
}
