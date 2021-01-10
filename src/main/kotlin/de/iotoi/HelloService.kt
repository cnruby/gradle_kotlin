package de.iotoi

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

//@Service("ms")
@Service()
class HelloService {
    fun getHello(): String {
        return "Hello @Service!\n"
    }
}
