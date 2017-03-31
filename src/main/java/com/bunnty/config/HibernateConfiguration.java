package com.bunnty.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.bunnty.config "})
@PropertySource(value = { "classpath:application.properties"} )
public class HibernateConfiguration {
	
	@Autowired
	private Environment enviroment;
	
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.bunnty.model"});
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
		}
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName( enviroment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(enviroment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(enviroment.getRequiredProperty("jdbc.username"));
		dataSource.setPassword( enviroment.getRequiredProperty("jdbc.password"));
		return dataSource;
	}
	public Properties hibernateProperties(){
		Properties properties = new Properties();
		properties.put("hibernate.dialect", enviroment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", enviroment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", enviroment.getRequiredProperty("hibernate.format_sql"));
		return properties;
	}
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s ) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(s);
		return txManager;
	}
}