package com.hoteis;

import com.hoteis.mapper.MapperConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@Import(MapperConfig.class)
public class ReservaDeHoteisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservaDeHoteisApplication.class, args);

	}

}
