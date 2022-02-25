package com.bakigoal.rabbitclient.consumer

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class EventConsumer {

    companion object {
        val logger: Logger = LoggerFactory.getLogger(EventConsumer::class.java)
    }

    @RabbitListener(queues = ["\${rabbit.queue}"])
    fun listener(event: String) {
        logger.info("received event $event")
    }
}