package com.bakigoal.r2dbcpostgres

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing


@SpringBootApplication
@EnableR2dbcAuditing
@EnableConfigurationProperties
class R2dbcPostgresApplication

fun main(args: Array<String>) {
    runApplication<R2dbcPostgresApplication>(*args)
}