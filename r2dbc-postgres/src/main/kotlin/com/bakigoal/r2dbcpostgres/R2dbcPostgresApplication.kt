package com.bakigoal.r2dbcpostgres

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class R2dbcPostgresApplication

fun main(args: Array<String>) {
    runApplication<R2dbcPostgresApplication>(*args)
}