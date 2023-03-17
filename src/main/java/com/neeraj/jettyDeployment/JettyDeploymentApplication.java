package com.neeraj.jettyDeployment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class JettyDeploymentApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JettyDeploymentApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(JettyDeploymentApplication.class, args);
	}

}
