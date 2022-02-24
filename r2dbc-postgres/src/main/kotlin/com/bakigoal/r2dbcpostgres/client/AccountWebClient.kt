package com.bakigoal.r2dbcpostgres.client

import com.bakigoal.r2dbcpostgres.dto.Account
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Component
class AccountWebClient {

    @Value("\${services.accountService.url}")
    lateinit var accountServiceUrl: String

    val client by lazy {
        WebClient.builder()
        .baseUrl(accountServiceUrl)
        .defaultCookie("cookieKey", "cookieValue")
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .defaultUriVariables(Collections.singletonMap("url", accountServiceUrl))
        .build()
    }

    fun findAll(): Flux<Account> {
        return client.get()
            .uri("/v1/account")
            .retrieve()
            .bodyToFlux(Account::class.java)
    }

    fun save(account: Mono<Account>): Mono<Account> {
        return client.post()
            .uri("/v1/account")
            .body(account, Account::class.java)
            .retrieve()
            .bodyToMono(Account::class.java)
    }

}
