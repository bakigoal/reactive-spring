package com.bakigoal.r2dbcpostgres.rest

import com.bakigoal.r2dbcpostgres.model.Book
import com.bakigoal.r2dbcpostgres.repo.BookRepo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.r2dbc.mapping.R2dbcMappingContext
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Flux

@WebFluxTest(controllers = [BookController::class])
internal class BookControllerTest {

    @MockBean
    lateinit var bookRepo: BookRepo
    @MockBean
    lateinit var r2dbcMappingContext: R2dbcMappingContext

    @Autowired
    private lateinit var webClient: WebTestClient


    @BeforeEach
    fun clearDb() {
        Mockito.`when`(bookRepo.findAll())
            .thenReturn(
                (Flux.fromIterable(listOf(Book(title = "book 1"), Book(title = "book 2"), Book(title = "book 3"))))
            )
    }

    @Test
    fun `get All`() {
        webClient.get().uri("/v1/book").exchange()
            .expectStatus().isOk
            .expectBody()
            .jsonPath("$[0].title").isEqualTo("book 1")
            .jsonPath("$[1].title").isEqualTo("book 2")
            .jsonPath("$[2].title").isEqualTo("book 3")
    }
}
