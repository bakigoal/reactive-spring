package com.bakigoal.webfluxmongo.repo

import com.bakigoal.webfluxmongo.model.Account
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import reactor.core.publisher.Mono
import reactor.test.StepVerifier


@SpringBootTest
class AccountReactiveRepoTest {

    @Autowired
    lateinit var repository: AccountReactiveRepo

    @BeforeEach
    fun initTest() {
        repository.deleteAll().block()
    }

    @Test
    fun `given value when findAllByValue then findAccount`() {
        repository.save(Account(null, "Bill", 12.3)).block()
        val accountFlux = repository.findAllByValue(12.3)
        StepVerifier
            .create(accountFlux)
            .assertNext { (id, owner, value) ->
                assertEquals("Bill", owner)
                assertEquals(12.3, value)
                assertNotNull(id)
            }
            .expectComplete()
            .verify()
    }

    @Test
    fun `given owner when findFirstByOwner then findAccount`() {
        repository.save(Account(null, "Bill", 12.3)).block()
        val accountMono = repository.findFirstByOwner(Mono.just("Bill"))
        StepVerifier
            .create(accountMono)
            .assertNext { (id, owner, value) ->
                assertEquals("Bill", owner)
                assertEquals(12.3, value)
                assertNotNull(id)
            }
            .expectComplete()
            .verify()
    }

    @Test
    fun `given account when save then saveAccount`() {
        val accountMono = repository.save(Account(null, "Bill", 12.3))
        StepVerifier
            .create(accountMono)
            .assertNext { (id) -> assertNotNull(id) }
            .expectComplete()
            .verify()
    }
}