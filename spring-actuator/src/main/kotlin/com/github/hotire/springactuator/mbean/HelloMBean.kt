package com.github.hotire.springactuator.mbean

interface HelloMBean {
    fun sayHello()
    fun add(x: Int, y: Int): Int
    val name: String
    var cacheSize: Int
}






