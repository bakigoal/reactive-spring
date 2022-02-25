package com.bakigoal.rabbitserver.config

import org.springframework.amqp.core.Queue
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitConfig {

    @Bean
    fun queue(@Value("\${rabbit.queue}") queueName: String) = Queue(queueName)
}