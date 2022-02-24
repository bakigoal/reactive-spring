package com.bakigoal.r2dbcpostgres.rest

import com.bakigoal.r2dbcpostgres.client.AccountWebClient
import com.bakigoal.r2dbcpostgres.dto.Account
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyExtractors
import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.RequestPredicates.POST
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.created
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono
import java.net.URI

@Configuration
@Component
class AccountController(@Autowired val accountWebClient: AccountWebClient) {

    @Bean
    fun route(): RouterFunction<ServerResponse> {
        return RouterFunctions
            .route(GET("/v1/account"), { getAll() })
            .andRoute(POST("/v1/account"), this::create)
    }

    private fun getAll(): Mono<ServerResponse> {
        return ok().body(accountWebClient.findAll(), Account::class.java)
    }

    private fun create(serverRequest: ServerRequest): Mono<ServerResponse> {
        return accountWebClient.save(serverRequest.body(BodyExtractors.toMono(Account::class.java)))
            .flatMap {
                created(URI.create("/v1/account/${it.id}")).bodyValue(it)
            }
    }
}

