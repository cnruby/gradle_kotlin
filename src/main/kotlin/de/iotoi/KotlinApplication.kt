package de.iotoi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.beans.factory.annotation.Value

@SpringBootApplication
class KotlinApplication {
	@Value("\${web.app.name}") val webAppName: String? = null

	@Bean
	fun init(@Value("\${web.app.name}") appName: String) = CommandLineRunner {
		println("$appName from init()!")
		println("$webAppName from init()!!")
	}
}

fun main(args: Array<String>) {
	runApplication<KotlinApplication>(*args)
}
