package de.iotoi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinApplication

fun main(args: Array<String>) {
	var applicationContext = runApplication<KotlinApplication>(*args)

	var helloComponent = applicationContext.getBean("helloComponent") as HelloComponent
	println(helloComponent.getHello())

	var helloService = applicationContext.getBean("helloService") as HelloService
	println(helloService.getHello())
}
