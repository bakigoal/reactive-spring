package com.bakigoal.webfluxmongo.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Account(
    @Id
    var id: String?,
    var owner: String?,
    var value: Double?
)