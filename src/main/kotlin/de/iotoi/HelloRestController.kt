package de.iotoi

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Value

@RestController
class HelloRestController {
    @Value(PropertyValues.WEB_APP_NAME)
    private val webAppName: String? = null

    @GetMapping("/api")
    fun helloKotlin(): String {
        return "$webAppName!!!\n"
    }
}