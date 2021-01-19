package de.iotoi

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.json.JSONObject
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.multipart.MultipartFile

import org.springframework.web.bind.annotation.RequestPart
import java.nio.charset.StandardCharsets


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
            (key, value) -> jsonMap.put(key, value)
        }

//        map.forEach {
//            (key, value) -> jsonMap.put( "$key", "$value" )
//        }

        return ResponseEntity(jsonMap.toString(), HttpStatus.OK)
    }

    @PostMapping(
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        path = ["/api/cmd", "/"]
    )
    fun helloCommand(
        @RequestBody strJSON: String?
    ): String? {
        val jsonObj = JSONObject(strJSON)
        val value: String = jsonObj["cmd"].toString() + ": we have received this value"
        jsonObj.put("cmd", value)
        return jsonObj.toString()
    }

    @PostMapping(
        consumes = [MediaType.MULTIPART_FORM_DATA_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        path = ["/api/upload"]
    )
    fun parseUploadFile(
        @RequestPart(value = "uploadX", required = true) multipartFile: MultipartFile?
    ): String? {
        val jsonObj = JSONObject()
        jsonObj.put("fileName", multipartFile?.originalFilename)
        jsonObj.put("fileContent", String(multipartFile!!.bytes, StandardCharsets.UTF_8))
        jsonObj.put("fileSize", multipartFile.size.toString())
        return jsonObj.toString()
    }
}
