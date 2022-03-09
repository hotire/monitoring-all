package com.github.hotire.springactuator

import mu.KLogger
import mu.KotlinLogging
import org.slf4j.Logger
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class LoggerDelegate : ReadOnlyProperty<Any?, Logger> {

    override operator fun getValue(thisRef: Any?, property: KProperty<*>): KLogger =
        KotlinLogging.logger(thisRef!!.javaClass.name)
}
