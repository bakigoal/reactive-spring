package com.bakigoal.r2dbcpostgres.repo

import com.bakigoal.r2dbcpostgres.model.Book
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface BookRepo : ReactiveCrudRepository<Book, Long> {

    fun findAllByAuthor(author: String): Flux<Book>
}