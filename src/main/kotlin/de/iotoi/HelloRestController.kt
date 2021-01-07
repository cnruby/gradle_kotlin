package de.iotoi

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloRestController {
    @GetMapping("/api")
    fun helloKotlin(): String {
        return "Hello @RestController!"
    }
}