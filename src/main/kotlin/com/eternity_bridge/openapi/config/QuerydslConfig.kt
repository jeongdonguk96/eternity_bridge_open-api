package com.eternity_bridge.openapi.config

import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class QuerydslConfig(
    private val em: EntityManager
) {

    @Bean
    fun jpaQueryFactory() = JPAQueryFactory(em)

}