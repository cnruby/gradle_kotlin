package de.iotoi

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired

//@Service("ms")
@Service()
class HelloService {
    @Value("\${web.app.name}")
    val webAppName: String? = null

    @Autowired
    private val halloService: HalloService? = null

    fun getHello(): String {
        return "$webAppName!\n"
    }

    fun getHallo(): String {
        if (halloService != null) {
            return halloService.getHallo()
        }
        return "Hallo Error from HalloService!"
    }
}
