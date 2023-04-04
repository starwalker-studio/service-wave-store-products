package com.wavestore.service.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan({ "com.wavestore.service.products.commons.entity" })
@SpringBootApplication(scanBasePackages = { 
		"com.wavestore.service.products.service",
		"com.wavestore.service.products.dao",
		"com.wavestore.service.products.controllers"})
public class ServiceWaveStoreProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceWaveStoreProductsApplication.class, args);
	}

}
