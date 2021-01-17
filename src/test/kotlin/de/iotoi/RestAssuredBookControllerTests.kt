package de.iotoi

import de.iotoi.model.Book
import io.restassured.RestAssured
import io.restassured.response.Response
import org.apache.commons.lang3.RandomStringUtils
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType


class RestAssuredBookControllerTests {
    private fun createRandomBook(): Book {
        val book = Book()
        book.title = RandomStringUtils.randomAlphabetic(10)
        book.author = RandomStringUtils.randomAlphabetic(15)
        return book
    }

    private fun createBookAsUri(book: Book): String {
        val response: Response = RestAssured.given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(book)
            .post(API_ROOT)
        return API_ROOT + "/" + response.jsonPath().get("id")
    }

    /*******************************************
     *
     * test finding books using variant methods
     *
     */
    @Test
    fun whenGetAllBooks_thenOK() {
        val response = RestAssured.get(API_ROOT)
        assertThat(HttpStatus.OK.value()).isEqualTo(response.statusCode)
    }

    @Test
    fun whenGetBooksByTitle_thenOK() {
        val book: Book = createRandomBook()
        createBookAsUri(book)
        val response = RestAssured.get(
            API_ROOT + "/title/" + book.title
        )
        assertThat(HttpStatus.OK.value()).isEqualTo(response.statusCode)
        assertThat(
            response.`as`<List<*>>(MutableList::class.java).isNotEmpty()
        ).isTrue
    }

    @Test
    fun whenGetCreatedBookById_thenOK() {
        val book: Book = createRandomBook()
        val location = createBookAsUri(book)
        val response = RestAssured.get(location)
        assertThat(HttpStatus.OK.value()).isEqualTo(response.statusCode)
        assertThat(book.title).isEqualTo(response.jsonPath()["title"])
    }

    @Test
    fun whenGetNotExistBookById_thenNotFound() {
        val response = RestAssured.get(API_ROOT + "/" + RandomStringUtils.randomNumeric(4))
        println("response.statusCode = " + response.statusCode)
        assertThat(HttpStatus.NOT_FOUND.value()).isEqualTo(response.statusCode)
    }

    /*************************************
     *
     * test creating a new book
     *
     */
    @Test
    fun whenCreateNewBook_thenCreated() {
        val book: Book = createRandomBook()
        val response: Response = RestAssured.given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(book)
            .post(API_ROOT)
        assertThat(HttpStatus.CREATED.value()).isEqualTo(response.statusCode)
    }

    /*************************************
     *
     * test updating an existing book
     *
     */
    @Test
    fun whenUpdateCreatedBook_thenUpdated() {
        val book: Book = createRandomBook()
        val location = createBookAsUri(book)
        book.id = location.split("api/books/").toTypedArray()[1].toLong()
        book.author = "newAuthor"
        var response: Response = RestAssured.given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(book)
            .put(location)
        assertThat(HttpStatus.OK.value()).isEqualTo(response.statusCode)
        response = RestAssured.get(location)
        assertThat(HttpStatus.OK.value()).isEqualTo(response.statusCode)
        assertThat("newAuthor").isEqualTo(response.jsonPath().get("author"))
    }

    companion object {
        private const val API_ROOT = "http://localhost:8080/api/books"
    }
}
