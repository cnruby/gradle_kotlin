package de.iotoi

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HelloHtmlController {
    @Value("\${web.app.name}")
    val webAppName: String? = null

    @GetMapping("/")
    fun homePage(model: Model): String {
        model["webAppName"] = "$webAppName"
        return "home"
    }
}