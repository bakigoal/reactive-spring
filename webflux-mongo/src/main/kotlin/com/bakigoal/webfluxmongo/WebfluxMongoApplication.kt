package com.bakigoal.webfluxmongo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.reactive.config.EnableWebFlux

@SpringBootApplication
@EnableWebFlux
class WebfluxMongoApplication

fun main(args: Array<String>) {
    runApplication<WebfluxMongoApplication>(*args)
}
