package de.iotoi

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired

//@Service("ms")
@Service
class HelloNativeService(val nativeService: HalloService) {
    @Value("\${web.app.name}")
    val webAppName: String? = null

    private final var halloService: HalloService? = null
    init{
        if (nativeService != null) {
            this.halloService = nativeService
        }
    }

    fun getHello(): String {
        return "$webAppName!\n"
    }

    fun getHallo(): String? {
        return halloService?.getHallo()
    }
}
