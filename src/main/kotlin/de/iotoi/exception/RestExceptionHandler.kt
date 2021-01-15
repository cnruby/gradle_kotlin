package de.iotoi.exception

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.lang.Exception


@ControllerAdvice
class RestExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(BookNotFoundException::class)
    protected fun handleNotFound(
        exception: Exception?, request: WebRequest?
    ): ResponseEntity<Any> {
        return handleExceptionInternal(
            exception!!,
            "{\"status\": \"${HttpStatus.NOT_FOUND}\", \"message\": \"Book not found\", \"class\": \"${RestExceptionHandler::class.java.name}\"}",
            HttpHeaders(),
            HttpStatus.NOT_FOUND,
            request!!
        )
    }
}