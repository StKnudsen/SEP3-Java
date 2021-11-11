package com.dnnr.DNNR_tier3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.dnnr")
public class DnnrTier3Application {

	public static void main(String[] args) {
		SpringApplication.run(DnnrTier3Application.class, args);
	}

}
