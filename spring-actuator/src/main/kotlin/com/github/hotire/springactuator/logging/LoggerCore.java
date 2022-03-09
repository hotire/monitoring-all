package com.github.hotire.springactuator.logging;

import org.slf4j.Marker;

import ch.qos.logback.classic.Level;
import ch.qos.logback.core.spi.FilterReply;

public class LoggerCore {

    /**
     * @see ch.qos.logback.classic.Logger#callTurboFilters(Marker, Level)
     */
    private FilterReply callTurboFilters(Marker marker, Level level) {
        return FilterReply.NEUTRAL;
    }
}
