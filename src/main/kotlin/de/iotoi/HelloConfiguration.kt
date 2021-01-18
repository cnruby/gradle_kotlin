package de.iotoi

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import de.iotoi.impl.HelloService
import org.springframework.context.annotation.Bean


@Configuration
@PropertySource("classpath:/hello.properties")
class HelloConfiguration {
    @Bean()
    fun getHelloServiceObject(): HelloService? {
        return HelloService()
    }

//    val helloService: HelloServiceable
//        @Bean()
//        get() = HelloService()
}