package com.techprimers;

import io.nats.client.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class NatsExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(NatsExampleApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			Connection connect = Nats.connect();
			Dispatcher dispatcher = connect.createDispatcher(message -> {
				System.out.println(String.format("Received Message[%s] from [%s]",
						new String(message.getData(), StandardCharsets.UTF_8), message.getSubject()));
			});
			dispatcher.subscribe("com.techprimers.*");
		};
	}
}
