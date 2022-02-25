package com.bakigoal.rabbitclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RabbitClientApplication

fun main(args: Array<String>) {
    runApplication<RabbitClientApplication>(*args)
}
