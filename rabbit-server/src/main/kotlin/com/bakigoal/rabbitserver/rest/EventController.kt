package com.bakigoal.rabbitserver.rest

import com.bakigoal.rabbitserver.publisher.EventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/event")
class EventController {

    @Autowired
    lateinit var eventPublisher: EventPublisher

    @PostMapping
    fun publish(@RequestBody event: String) {
        eventPublisher.publishEvent(event)
    }
}