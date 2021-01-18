package de.iotoi.impl

import de.iotoi.HelloPropertyValues
import de.iotoi.PropertyValues
import org.springframework.beans.factory.annotation.Value

class HelloService : HelloServiceable {
//    @Value(PropertyValues.WEB_APP_NAME)
    @Value(HelloPropertyValues.WEB_APP_NAME)
    private val webAppName: String? = null

    override val hello: String
        get() = "$webAppName!\n"
}