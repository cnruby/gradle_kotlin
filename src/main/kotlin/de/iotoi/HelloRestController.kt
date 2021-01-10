package de.iotoi

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloRestController(val helloService: HelloService, val helloNativeService: HelloNativeService) {

    @GetMapping("/api/hello")
    fun helloService(): String {
        return helloService.getHello()
    }

    @GetMapping("/api/hallo")
    fun halloService(): String? {
        return helloService.getHallo()
    }

    @GetMapping("/api/hello_native")
    fun helloNativeService(): String {
        return helloNativeService.getHello()
    }

    @GetMapping("/api/hallo_native")
    fun halloNativeService(): String? {
        return helloNativeService.getHallo()
    }
}