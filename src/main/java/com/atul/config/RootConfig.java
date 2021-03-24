package com.atul.config;

import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import static org.hibernate.cfg.Environment.*;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("com.atul")
public class RootConfig 
{
	
	@Autowired
	private Environment environment;
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory()
	{
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		System.out.println(environment.hashCode());
		Properties properties = new Properties();
		properties.setProperty(URL,environment.getProperty("url"));
		properties.setProperty(DRIVER,environment.getProperty("driver"));
		properties.setProperty(USER,environment.getProperty("user"));
		properties.setProperty(PASS,environment.getProperty("password"));
		properties.setProperty(HBM2DDL_AUTO,environment.getProperty("hbm2ddl.auto"));
		properties.setProperty(SHOW_SQL,environment.getProperty("show_sql"));
		properties.setProperty(FORMAT_SQL,environment.getProperty("format_sql"));
		properties.setProperty(C3P0_MIN_SIZE,environment.getProperty("min"));
		properties.setProperty(C3P0_MAX_SIZE,environment.getProperty("max"));
		properties.setProperty(C3P0_ACQUIRE_INCREMENT,environment.getProperty("increment"));
		
		bean.setHibernateProperties(properties);
		
		return bean;
	}
}
