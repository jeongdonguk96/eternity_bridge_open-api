package com.eternity_bridge.openapi.common

import com.eternity_bridge.openapi.common.service.ResponseService
import com.eternity_bridge.openapi.pet.repository.PetRepository
import com.eternity_bridge.openapi.pet.service.PetService
import jakarta.persistence.Entity
import jakarta.persistence.EntityManager
import org.junit.jupiter.api.AfterEach
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.transaction.annotation.Transactional
import kotlin.jvm.java

@Transactional
@ActiveProfiles("test")
@SpringBootTest
abstract class AbstractTest : InitializingBean {
    @Autowired lateinit var em: EntityManager
    @Autowired lateinit var petService: PetService
    @Autowired lateinit var responseService: ResponseService
    @Autowired lateinit var petRepository: PetRepository
    private lateinit var entities: List<String>

    override fun afterPropertiesSet() {
        entities = em.metamodel.entities
            .filter { it.javaType.isAnnotationPresent(Entity::class.java) }
            .map { it.javaType.simpleName.lowercase() }
    }

    @AfterEach
    fun cleanUp() {
        // 1. 영속성 컨텍스트에 남겨진 SQL을 실행한다.
        em.flush()

        // 2. 테이블 간의 참조 무결성을 비활성화한다.
        em.createNativeQuery("SET REFERENTIAL_INTEGRITY FALSE").executeUpdate()

        // 3. 테이블들을 ID 값을 1로 초기화해준다.
        entities.forEach { entity ->
            em.createNativeQuery("TRUNCATE TABLE $entity").executeUpdate()
            em.createNativeQuery("ALTER TABLE $entity ALTER COLUMN id RESTART WITH 1").executeUpdate()
        }

        // 4. 참조 무결성을 활성화한다.
        em.createNativeQuery("SET REFERENTIAL_INTEGRITY TRUE").executeUpdate()
    }

}