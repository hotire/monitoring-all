package com.github.hotire.springactuator.custom

import ch.qos.logback.classic.Level
import ch.qos.logback.classic.spi.EventArgUtil
import io.micrometer.core.instrument.Tag
import io.micrometer.core.instrument.Tags
import org.springframework.util.StringUtils

/**
 * @see org.springframework.boot.actuate.metrics.web.servlet.WebMvcTagsProvider
 */
interface ErrorTagsProvider {

    fun getTags(
        level: Level,
        format: String,
        params: Array<Any>?,
        t: Throwable?
    ): Iterable<Tag>
}

class DefaultErrorTagsProvider : ErrorTagsProvider {

    override fun getTags(
        level: Level,
        format: String,
        params: Array<Any>?,
        t: Throwable?
    ): Iterable<Tag> {
        return Tags.of(
            Tag.of("level", level.toString()),
            Tag.of("format", format),
            errorTags(params, t)
        )
    }

    private fun errorTags(params: Array<Any>?, t: Throwable?): Tag {
        val error = (t ?: extractThrowable(params))?.let {
            val simpleName: String? = it.javaClass.simpleName
            if (StringUtils.hasText(simpleName)) simpleName else it.javaClass.name
        } ?: "null"
        return Tag.of("error", error)
    }

    private fun extractThrowable(argArray: Array<Any>?): Throwable? {
        return EventArgUtil.extractThrowable(argArray)
    }
}
