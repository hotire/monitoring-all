package com.github.hotire.springactuator

import io.micrometer.core.instrument.binder.jvm.DiskSpaceMetrics
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.File

/**
 * https://github.com/micrometer-metrics/micrometer/pull/703
 */
@Configuration
class PrometheusMetricsConfig {

    @Bean
    fun diskSpaceMetrics() = DiskSpaceMetrics(File("/"))
}
