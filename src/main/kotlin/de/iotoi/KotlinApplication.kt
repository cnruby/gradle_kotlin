package de.iotoi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.CommandLineRunner

@SpringBootApplication
class KotlinApplication : CommandLineRunner {
	override fun run(vararg args: String?) {
		for (arg in args) {
			println(arg)
		}
	}
}

fun main(args: Array<String>) {
	runApplication<KotlinApplication>(*args)
}
