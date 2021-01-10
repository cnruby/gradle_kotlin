package de.iotoi

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value

@RestController
class HelloRestController(val helloService: HelloService, val helloComponent: HelloComponent) {
    @GetMapping("/api/service")
    fun helloService(): String {
        return helloService.getHello()
    }

    @GetMapping("/api/component")
    fun helloComponent(): String {
        return helloComponent.getHello()
    }
}