package com.github.hotire.springactuator.custom

import org.junit.jupiter.api.Test
import java.util.concurrent.atomic.DoubleAdder

internal class ErrorMetricsTurboFilterTest {

    @Test
    fun test() {
        val adder = DoubleAdder()
        adder.add(1.0)
        println(adder)
        adder.add(Double.MAX_VALUE)
        println(adder)
        adder.add(10.0)
        println(adder)


    }
}