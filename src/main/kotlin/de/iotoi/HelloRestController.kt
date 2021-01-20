package de.iotoi

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Schema
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

import org.springframework.core.io.ByteArrayResource
import org.springframework.core.io.Resource
import org.springframework.http.HttpHeaders
import java.io.IOException
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestMapping
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

@RestController
class HelloRestController(val helloService: HelloService) {
    @Operation(summary = "Unit 222: Hello JSONObject for class `String`")
    @GetMapping("/api/str")
    fun helloString(): String {
        return helloService.getStringHello()
    }

    @Operation(summary = "Unit 222: Hello JSONObject for class `ResponseEntity`")
    @GetMapping(path= ["/api/resp"], produces= [MediaType.APPLICATION_JSON_VALUE])
    fun helloResponseEntity(): ResponseEntity<String> {
        val jsonResp: JSONObject = helloService.getJSONObjectHello()
        return ResponseEntity(jsonResp.toString(), HttpStatus.OK)
    }

    @Operation(summary = "Unit 222: Hello JSONObject for class `Map`")
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

    @Operation(summary = "Unit 223: Hello @PostMapping and @RequestBody!")
    @PostMapping(
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        path = ["/api/cmd", "/"]
    )
    fun helloCommand(
        @Schema(
            example = "{\"cmd\":\"ls\"}",
            format = "json",
            description = "Get a information by the json format.",
            required = true
        )
        @RequestBody strJSON: String?
    ): String? {
        val jsonObj = JSONObject(strJSON)
        val value: String = jsonObj["cmd"].toString() + ": we have received this value"
        jsonObj.put("cmd", value)
        return jsonObj.toString()
    }

    @Operation(summary = "Unit 224: Hello @PostMapping and @RequestPart!")
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

    @Operation(summary = "Unit 225: Hello @RequestMapping and @RequestParam for url `test_download`")
    @RequestMapping(path = ["/api/test_download"], method = [RequestMethod.GET])
    @Throws(IOException::class)
    fun testDownload(@RequestParam("imageX") imageName: String): String? {
        val strPath: String = "./server_download" + File.separator.toString() + imageName
        val file = File(strPath)
        val jsonObj = JSONObject()
        jsonObj.put("path", strPath)
        jsonObj.put("fileSize", file.length())
        return jsonObj.toString()
    }

    @Operation(summary = "Unit 225: Hello @RequestMapping and @RequestParam for url `download`")
    @RequestMapping(path = ["/api/download"], method = [RequestMethod.GET])
    @Throws(IOException::class)
    fun parseDownloadFile(@RequestParam("imageX") imageName: String): ResponseEntity<Resource?>? {
        val file = File("./server_download" + File.separator.toString() + imageName )
        val header = HttpHeaders()
        // header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=local_kotlin.png")
        header.add("Cache-Control", "no-cache, no-store, must-revalidate")
        header.add("Pragma", "no-cache")
        header.add("Expires", "0")
        val path: Path = Paths.get(file.absolutePath)
        val resource = ByteArrayResource(Files.readAllBytes(path))
        return ResponseEntity.ok()
            .headers(header)
            .contentLength(file.length())
            .contentType(MediaType.parseMediaType("application/octet-stream"))
            .body(resource)
    }

}
