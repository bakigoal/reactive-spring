package com.bakigoal.rabbitserver.publisher

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.amqp.core.AmqpTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class EventPublisher {

    companion object {
        val logger:Logger = LoggerFactory.getLogger(EventPublisher::class.java)
    }

    @Autowired
    lateinit var rabbitTemplate: AmqpTemplate

    @Value("\${rabbit.queue}")
    lateinit var queueName: String

    fun publishEvent(event: String) {
        rabbitTemplate.convertAndSend(queueName, event)
        logger.info("published event $event")
    }
}