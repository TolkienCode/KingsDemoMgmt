package org.kingsdemo.kdmgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class KdMgmtApp extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(KdMgmtApp.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(KdMgmtApp.class, args);
	}
}
