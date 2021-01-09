package de.iotoi

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

//@Service("ms")
@Service()
class HelloService {
    @Value("\${web.app.name}") val webAppName: String? = null

    fun getHello(): String {
        return "$webAppName!\n"
    }
}
