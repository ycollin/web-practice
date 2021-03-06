package com.example.webpractice;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.val;

@Configuration
public class WebApplicationConfigration implements WebMvcConfigurer {

	// Login filter
	@Bean
	FilterRegistrationBean<LoginCheckFilter> myFilterRegistration() {
		val frb = new FilterRegistrationBean<LoginCheckFilter>();
		frb.setFilter(new LoginCheckFilter());
		frb.setUrlPatterns(Arrays.asList("/*"));
		return frb;
	}

	// heroku jawsDB
	// 参考：https://devcenter.heroku.com/articles/cleardb
	@Bean
	public DataSource dataSource() throws URISyntaxException {
		URI dbUri = new URI(System.getenv("JAWSDB_URL"));

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://" + dbUri.getHost() + dbUri.getPath());
		dataSource.setUsername( dbUri.getUserInfo().split(":")[0]);
		dataSource.setPassword(dbUri.getUserInfo().split(":")[1]);
		return dataSource;
	}

    /**
     * ValidationメッセージをUTF-8で設定できるようにする
     */
    @Override
    public Validator getValidator() {
        return validator();
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setValidationMessageSource(messageSource());
        return validator;
    }

    private MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/ValidationMessages");
        //UTF-8
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

}
