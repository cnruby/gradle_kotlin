package de.iotoi

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.json.JSONObject
import java.util.HashMap

//@Service("ms")
@Service()
class HelloService {
    @Value("\${web.app.name}") val webAppName: String? = null

    fun getStringHello(): String {
        val jsonObj = JSONObject()
        jsonObj.put("String", "$webAppName")
        return jsonObj.toString()
    }

    fun getJSONObjectHello(): JSONObject {
        val jsonEntity = JSONObject()
        jsonEntity.put("ResponseEntity", "$webAppName")
        return jsonEntity
    }

    fun getMapHello(): MutableMap<String, String> {
        val map: MutableMap<String, String> = HashMap()
        map["Map"] = "$webAppName"
        return map
    }
}
