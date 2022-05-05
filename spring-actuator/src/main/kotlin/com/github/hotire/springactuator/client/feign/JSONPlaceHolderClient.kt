package com.github.hotire.springactuator.client.feign

import io.micrometer.core.annotation.Timed
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/feign")
@RestController
class JSONPlaceHolderClientController(private val client: JSONPlaceHolderClient) {

    @GetMapping("/posts")
    fun getPosts() = client.getPosts()
}

@FeignClient(value = "jplaceholder", url = "https://jsonplaceholder.typicode.com/")
interface JSONPlaceHolderClient {

    @Timed
    @GetMapping("/posts")
    fun getPosts(): List<Post>
}

data class Post(
    var userId: Long? = null,
    var id: Long? = null,
    var title: String? = null,
    var body: String? = null
)
