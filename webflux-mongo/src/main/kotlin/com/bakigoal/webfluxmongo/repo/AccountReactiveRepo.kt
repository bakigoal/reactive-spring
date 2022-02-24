package com.bakigoal.webfluxmongo.repo

import com.bakigoal.webfluxmongo.model.Account
import org.springframework.data.domain.Example
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface AccountReactiveRepo : ReactiveMongoRepository<Account, String> {

    fun findAllByValue(value: Double): Flux<Account>
    fun findFirstByOwner(owner: Mono<String>): Mono<Account>
}