package com.bakigoal.r2dbcpostgres.rest

import com.bakigoal.r2dbcpostgres.client.AccountWebClient
import com.bakigoal.r2dbcpostgres.dto.Account
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/v1/account")
class AccountController(@Autowired val accountWebClient: AccountWebClient) {

    @GetMapping
    fun getAll(): Flux<Account> = accountWebClient.findAll()

    @PostMapping
    fun create(@RequestBody account: Account): Mono<Account> = accountWebClient.save(account)
}