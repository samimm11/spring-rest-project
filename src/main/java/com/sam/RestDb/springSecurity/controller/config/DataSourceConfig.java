package com.sam.RestDb.springSecurity.controller.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@Profile("dev")
public class DataSourceConfig {

	@Value("${datasource.url}")
	private String url;

	@Value("${datasource.username}")
	private String userName;

	@Value("${datasource.password}")
	private String password;

	@Bean
	public DataSource datasource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);
		return dataSource;
	}
}
