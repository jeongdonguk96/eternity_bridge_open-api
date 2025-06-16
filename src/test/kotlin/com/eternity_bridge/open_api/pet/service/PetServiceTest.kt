package com.eternity_bridge.open_api.pet.service

import com.eternity_bridge.open_api.pet.dto.CreatePetRequest
import com.eternity_bridge.open_api.pet.enums.PetType
import com.eternity_bridge.open_api.pet.repository.PetRepository
import com.navercorp.fixturemonkey.FixtureMonkey
import com.navercorp.fixturemonkey.kotlin.KotlinPlugin
import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import com.navercorp.fixturemonkey.kotlin.giveMeOne
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.slf4j.MDC
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.transaction.annotation.Transactional

@Transactional
@ActiveProfiles("test")
@SpringBootTest
class PetServiceTest(
    @Autowired private val petService: PetService,
    @Autowired private val petRepository: PetRepository
) : FunSpec() {

    init {
        beforeTest {
            MDC.put("trxId", "test-transaction-id")
        }

        afterTest {
            MDC.clear()
        }

        test("반려동물이 성공적으로 생성된다.") {
            // given
            val request = PetFixtureFactory.createPetRequest(
                name = "보나",
                petType = PetType.DOG,
            )
            val memberId = 1L

            // when
            val result = petService.createPet(request, memberId)

            // then
            petRepository.existsById(result) shouldBe true
            petRepository.count() shouldBe 1L
            result shouldBe 1L
        }
    }

}