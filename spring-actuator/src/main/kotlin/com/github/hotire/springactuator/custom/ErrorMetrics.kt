package com.github.hotire.springactuator.custom

import ch.qos.logback.classic.LoggerContext
import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.binder.MeterBinder

/**
 * @see io.micrometer.core.instrument.binder.logging.Log4j2Metrics
 */
class ErrorMetrics(val context: LoggerContext) : MeterBinder {

    override fun bindTo(registry: MeterRegistry) {
        context.addTurboFilter(ErrorMetricsTurboFilter(registry, DefaultErrorTagsProvider()))
    }
}
