package de.iotoi

import de.iotoi.model.Book
import io.restassured.RestAssured
import org.apache.commons.lang3.RandomStringUtils
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType


@TestMethodOrder(OrderAnnotation::class)
class RestAssuredOrderTests {
    private fun createRandomBook(): Book {
        val book = Book()
        book.title = RandomStringUtils.randomAlphabetic(10)
        book.author = RandomStringUtils.randomAlphabetic(15)
        return book
    }

    @Test
    @Order(1)
    fun firstTest() {
        val response = RestAssured.get(API_ROOT)
        Assertions.assertThat(HttpStatus.OK.value()).isEqualTo(response.statusCode)

        output.append("get;")
    }

    @Test
    @Order(2)
    fun secondTest() {
        val book = createRandomBook()
        val response = RestAssured.given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(book)
            .post(API_ROOT)
        Assertions.assertThat(HttpStatus.CREATED.value()).isEqualTo(response.statusCode)

        output.append("create;")
    }

    companion object {
        private const val API_ROOT = "http://localhost:8080/api/books"
        private val output = StringBuilder("")
        @AfterAll
        fun assertOutput() {
            Assertions.assertThat(output.toString()).isEqualTo("get;create;")
        }
    }
}
