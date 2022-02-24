package com.bakigoal.r2dbcpostgres.rest

import com.bakigoal.r2dbcpostgres.model.Book
import com.bakigoal.r2dbcpostgres.repo.BookRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import java.util.*

@RestController
@RequestMapping("/v1/book")
class BookController {

    @Autowired
    lateinit var bookRepo: BookRepo

    @GetMapping
    fun findAll() = bookRepo.findAll()

    @GetMapping("/{id}")
    fun find(@PathVariable id: String) = bookRepo.findById(id)

    @PostMapping
    fun create(@RequestBody book: Book): Mono<Book> {
        return bookRepo.save(book)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody book: Book): Mono<Book> {
        book.id = id
        return bookRepo.save(book)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) =
        bookRepo.findById(id).doOnNext { bookRepo.delete(it).subscribe() }
}