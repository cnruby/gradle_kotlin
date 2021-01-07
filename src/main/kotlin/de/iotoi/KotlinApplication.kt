package de.iotoi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.boot.CommandLineRunner

@SpringBootApplication
class KotlinApplication {
	@Bean
	fun init() = CommandLineRunner {
		println("Hello World!")
	}

	@Bean
	fun hallo() {
		println("Hallo Welt!")
	}

	fun niHao() = CommandLineRunner {
		println("世界，你好!")
	}
}

fun main(args: Array<String>) {
	runApplication<KotlinApplication>(*args)
}
