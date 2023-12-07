package com.javaftuit.InventorySerivce;

import com.javaftuit.InventorySerivce.model.Inventory;
import com.javaftuit.InventorySerivce.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventorySerivceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(InventorySerivceApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(InventorySerivceApplication.class);
	}

//	@Bean
//	public CommandLineRunner loadData(InventoryRepository repository) {
//
//		return args -> {
//
//			Inventory inventory = new Inventory();
//			inventory.setSkuCode("iphone13");
//			inventory.setQuantity(2);
//
//			Inventory inventory1 = new Inventory();
//			inventory1.setSkuCode("iphone14");
//			inventory1.setQuantity(0);
//
//			repository.save(inventory1);
//			repository.save(inventory);
//		};
//
//	}
}
