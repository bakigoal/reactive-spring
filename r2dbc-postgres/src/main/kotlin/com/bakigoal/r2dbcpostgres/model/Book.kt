package com.bakigoal.r2dbcpostgres.model

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table
data class Book(
    @Id
    var id: Long? = null,
    var title: String,
    var author: String? = null,
    @CreatedDate
    var createTime: LocalDateTime? = null,
    @LastModifiedDate
    var lastModifyTime: LocalDateTime? = null
)