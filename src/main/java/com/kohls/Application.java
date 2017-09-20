package com.kohls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;



@EnableCircuitBreaker
@EnableHystrix
@SpringBootApplication
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
		System.setProperty("security.basic.enabled", "false");
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        log.debug("Spring context loaded");
    }

	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
		/*LogbackValve logbackValve = new LogbackValve();
		// point to logback-access.xml
		logbackValve.setFilename("logback-access.xml");
		tomcat.addContextValves(logbackValve);*/
		return tomcat;
	}
}