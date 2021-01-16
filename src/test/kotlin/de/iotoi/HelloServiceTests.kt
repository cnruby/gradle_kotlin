package de.iotoi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.*
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class HelloServiceTests() {
	@Autowired
	var helloService: HelloService? = null

	@Value("\${web.app.name}")
	val webAppName: String? = null

	@DisplayName("Test JUnit Integration with Spring @Autowired")
	@Test
	fun testAnnotationGetHello() {
		assertEquals("${webAppName}!", "Hello JUnit 5!")
		assertEquals("${webAppName}!\n", helloService?.getHello())
	}
}
