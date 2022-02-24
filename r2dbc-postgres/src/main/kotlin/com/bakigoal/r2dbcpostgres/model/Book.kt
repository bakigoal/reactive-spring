package com.bakigoal.r2dbcpostgres.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table
data class Book(
    @Id
    var id: Long? = null,
    var title: String,
    var author: String? = null
)