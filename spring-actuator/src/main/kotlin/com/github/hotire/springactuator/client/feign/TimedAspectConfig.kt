package com.github.hotire.springactuator.client.feign

import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.Tag
import io.micrometer.core.instrument.Tags
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.reflect.MethodSignature
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.AnnotationUtils
import org.springframework.web.bind.annotation.GetMapping
import java.util.function.Function

@Configuration
class TimedAspectConfig {

    @Bean
    fun timedAspect(registry: MeterRegistry) = io.micrometer.core.aop.TimedAspect(registry, tagsBasedOnJoinPoint())

    fun tagsBasedOnJoinPoint(): Function<ProceedingJoinPoint, Iterable<Tag>> {
        return Function<ProceedingJoinPoint, Iterable<Tag>>() {
            val methodSignature = it.signature as MethodSignature

            val annoation: GetMapping? = AnnotationUtils.findAnnotation(methodSignature.method, GetMapping::class.java)

            Tags.of(
                "class", it.getStaticPart().getSignature().getDeclaringTypeName(),
                "method", it.getStaticPart().getSignature().getName()
            )
        }
    }
}
