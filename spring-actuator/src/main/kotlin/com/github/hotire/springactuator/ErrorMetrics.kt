package com.github.hotire.springactuator

import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.binder.MeterBinder

/**
 * @see io.micrometer.core.instrument.binder.logging.Log4j2Metrics
 */
class ErrorMetrics : MeterBinder {
    override fun bindTo(registry: MeterRegistry) {
        TODO("Not yet implemented")
    }
}
