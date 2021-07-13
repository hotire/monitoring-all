package com.github.hotire.springactuator

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Hello(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
)


interface HelloRepository : JpaRepository<Hello, Long>

@Service
class HelloService(private val helloRepository: HelloRepository) {
    fun findById(id: Long) = helloRepository.findById(id)
    fun create() = helloRepository.save(Hello())
    fun findAll() = helloRepository.findAll()
}



@RestController
@RequestMapping("/hello")
class HelloController(private val helloService: HelloService) {

    @GetMapping
    fun list() = helloService.findAll()

    @GetMapping("/{id}")
    fun hello(@PathVariable id: Long) = helloService.findById(id)

    @GetMapping("/create")
    fun create() = helloService.create()
}
