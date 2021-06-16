package it.luca.data;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.IntStream;

@Slf4j
@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) {

		log.info("Starting main class");
		IntStream.range(0, args.length).forEach(i -> log.info("Argument # {}: {}", i, args[i]));
		//SpringApplication.run(Application.class, args);
	}
}
