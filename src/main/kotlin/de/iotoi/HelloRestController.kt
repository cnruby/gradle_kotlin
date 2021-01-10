package de.iotoi

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloRestController(val helloService: HelloService) {
    @GetMapping("/api/hello")
    fun helloService(): String {
        return helloService.getHello()
    }

    @GetMapping("/api/hallo")
    fun halloService(): String {
        return helloService.getHallo()
    }
}