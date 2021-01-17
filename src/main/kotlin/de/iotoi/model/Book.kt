package de.iotoi.model

import javax.persistence.*
import org.hibernate.annotations.GenericGenerator

// @Suppress("NAME_SHADOWING")
@Entity
@Table(name="books")
class Book {
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(
        strategy= GenerationType.AUTO,
        generator="native"
    )
    @GenericGenerator(
        name = "native",
        strategy = "native"
    )
    var id: Long = 0

    @Column(nullable = false, unique = true)
    var title: String? = null

    @Column(nullable = false)
    var author: String? = null

    constructor() : super()
    constructor(title: String?, author: String?) : super() {
        this.title = title
        this.author = author
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (author == null) 0 else author.hashCode()
        result = prime * result + (id xor (id ushr 32)).toInt()
        result = prime * result + if (title == null) 0 else title.hashCode()
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as Book
        if (author == null) {
            if (other.author != null) return false
        } else if (author != other.author) return false
        if (id != other.id) return false
        if (title == null) {
            if (other.title != null) return false
        } else if (title != other.title) return false
        return true
    }

    override fun toString(): String {
        return "Book [id=$id, title=$title, author=$author]"
    }
}
