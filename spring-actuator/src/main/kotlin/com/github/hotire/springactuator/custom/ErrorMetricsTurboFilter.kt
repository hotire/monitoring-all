package com.github.hotire.springactuator.custom

import ch.qos.logback.classic.Level
import ch.qos.logback.classic.Logger
import ch.qos.logback.classic.turbo.TurboFilter
import ch.qos.logback.core.spi.FilterReply
import io.micrometer.core.instrument.Counter
import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.binder.BaseUnits
import org.slf4j.Marker

/**
 * @see ch.qos.logback.classic.turbo.TurboFilter
 * @see io.micrometer.core.instrument.binder.logging.MetricsTurboFilter
 */
class ErrorMetricsTurboFilter(
    private val registry: MeterRegistry,
    private val errorTagsProvider: ErrorTagsProvider
) : TurboFilter() {

    override fun decide(marker: Marker?, logger: Logger?, level: Level?, format: String?, params: Array<Any>?, t: Throwable?): FilterReply {
        if (format.isNullOrEmpty()) {
            return FilterReply.NEUTRAL
        }

        if (level?.isGreaterOrEqual(logger?.effectiveLevel) == true) {
            when (level.toInt()) {
                Level.ERROR_INT, Level.WARN_INT -> {
                    val counter = Counter.builder("custom.error.events")
                        .tags(errorTagsProvider.getTags(level, format, params, t))
                        .baseUnit(BaseUnits.EVENTS)
                        .register(registry)

                    counter.increment()
                }
            }
        }

        return FilterReply.NEUTRAL
    }
}
