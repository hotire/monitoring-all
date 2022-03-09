package com.github.hotire.springactuator.custom

import ch.qos.logback.classic.LoggerContext
import io.micrometer.core.instrument.MeterRegistry
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ErrorMetricsConfig {

    @Bean
    fun errorMetrics(registry: MeterRegistry): ErrorMetrics {
        return ErrorMetrics((LoggerFactory.getILoggerFactory() as LoggerContext))
    }
}
