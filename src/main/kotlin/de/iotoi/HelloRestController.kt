package de.iotoi

import de.iotoi.impl.HelloServiceable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.ApplicationContext

import org.springframework.context.annotation.AnnotationConfigApplicationContext


@RestController
class HelloRestController {
    @Value(PropertyValues.WEB_APP_NAME)
    private val webAppName: String? = null

    // An annotation argument must be a compile-time constant
    @GetMapping(HelloPropertyValues.HELLO_API)
    fun helloKotlin(): String {
        return "$webAppName!\n"
    }

    @GetMapping("/")
    fun helloServiceKotlin(): String? {
        val context: ApplicationContext = AnnotationConfigApplicationContext(HelloConfiguration::class.java)
        val objHelloManager = context.getBean(HelloServiceable::class.java)
        return objHelloManager.hello
    }

}