package de.iotoi

import de.iotoi.model.Book
import de.iotoi.model.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.function.Supplier
import de.iotoi.exception.BookNotFoundException

@RestController
@RequestMapping("/api/books")
class BookRestController {
    @Autowired
    private val bookRepository: BookRepository? = null

    // curl localhost:8080/api/books | json_pp
    @GetMapping
    fun findAll(): Iterable<*>? {
        return bookRepository!!.findAll()
    }

    // curl localhost:8080/api/books/title/{bookTitle} | json_pp
    // curl localhost:8080/api/books/title/Rust | json_pp
    @GetMapping("/title/{bookTitle}")
    fun findByTitle(@PathVariable bookTitle: String?): List<Book?>? {
        return bookRepository!!.findByTitle(bookTitle)
    }

    // curl localhost:8080/api/books/1 | json_pp
    @GetMapping("/{id}")
    fun findOne(@PathVariable id: Long?): Book? {
        return bookRepository!!.findById(id!!)
            .orElseThrow { BookNotFoundException() }
    }

    // curl -H "Content-Type: application/json" -X POST -d '{"title":"Java","author":"Joe"}' localhost:8080/api/books | json_pp
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody book: Book?): Book? {
        return bookRepository!!.save(book!!)
    }

    // curl -X DELETE localhost:8080/api/books/{id} | json_pp
    // curl -X DELETE localhost:8080/api/books/1 | json_pp
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long?) {
        bookRepository!!.findById(id!!)
            .orElseThrow(Supplier<RuntimeException> { RuntimeException() })
        bookRepository.deleteById(id)
    }

    // curl -H "Content-Type: application/json" -X PUT -d '{"title":"Rust","author":"Leo"}' localhost:8080/api/books/{id} | json_pp
    // curl -H "Content-Type: application/json" -X PUT -d '{"title":"Rust","author":"Leo"}' localhost:8080/api/books/1 | json_pp
    @PutMapping("/{id}")
    fun updateBook(@RequestBody requestBook: Book, @PathVariable id: Long?): Book? {
        val book: Book = bookRepository!!.findById(id!!)
            .orElseThrow(Supplier<RuntimeException> { RuntimeException() }) as Book
        book.title = requestBook.title
        book.author = requestBook.author
        return bookRepository.save(book)
    }
}