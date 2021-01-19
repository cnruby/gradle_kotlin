package de.iotoi

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.json.JSONObject
import java.util.HashMap

@RestController
class HelloRestController(val helloService: HelloService) {
    @GetMapping("/api/str")
    fun helloString(): String {
        return helloService.getStringHello()
    }

    @GetMapping(path= ["/api/resp"], produces= [MediaType.APPLICATION_JSON_VALUE])
    fun helloResponseEntity(): ResponseEntity<String> {
        val jsonResp: JSONObject = helloService.getJSONObjectHello()
        return ResponseEntity(jsonResp.toString(), HttpStatus.OK)
    }

    @GetMapping("/api/map")
    fun helloMap(): ResponseEntity<String> {
        val jsonMap = JSONObject()

        val map: MutableMap<String, String> = helloService.getMapHello()
        map.entries.stream().forEach {
            (key, value) -> jsonMap.put( "$key", "$value" )
        }

//        map.forEach {
//            (key, value) -> jsonMap.put( "$key", "$value" )
//        }

        return ResponseEntity(jsonMap.toString(), HttpStatus.OK)
    }
}