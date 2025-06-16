package com.eternity_bridge.open_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class OpenApiApplication

fun main(args: Array<String>) {
	runApplication<OpenApiApplication>(*args)
}
