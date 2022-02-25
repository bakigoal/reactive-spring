package com.bakigoal.rabbitserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RabbitServerApplication

fun main(args: Array<String>) {
    runApplication<RabbitServerApplication>(*args)
}
