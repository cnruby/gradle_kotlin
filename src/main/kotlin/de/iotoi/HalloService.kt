package de.iotoi

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service()
class HalloService {
    fun getHallo(): String {
        return "Hallo Welt!\n"
    }
}
