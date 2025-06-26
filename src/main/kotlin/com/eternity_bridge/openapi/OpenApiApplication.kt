package com.eternity_bridge.openapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class OpenApiApplication

fun main(args: Array<String>) {
	runApplication<OpenApiApplication>(*args)
}
