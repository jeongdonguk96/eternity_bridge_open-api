package com.eternity_bridge.openapi.pet.service

import com.eternity_bridge.openapi.common.AbstractTest
import com.eternity_bridge.openapi.pet.enums.PetType
import org.assertj.core.api.SoftAssertions.assertSoftly
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.slf4j.MDC

class PetServiceTest : AbstractTest() {

    @BeforeEach
    fun setUp() {
        MDC.put("trxId", "test-transaction-id")
    }

    @AfterEach
    fun tearDown() {
        petRepository.deleteAll()
        MDC.clear()
    }

    @Test
    fun `반려동물이 생성된다`() {
        // given
        val request = PetFixtureFactory.createPetRequest(
            name = "보나",
            petType = PetType.DOG,
        )
        val memberId = 1L

        // when
        val result = petService.createPet(request, memberId)

        // then
        assertSoftly {
            it.assertThat(result).isNotNull
            it.assertThat(result).isEqualTo(1L)
            it.assertThat(petRepository.count()).isEqualTo(1L)
            it.assertThat(petRepository.existsById(result)).isTrue
        }
    }

    @Test
    fun `반려동물이 조회된다`() {
        // given
        val request = PetFixtureFactory.createPetRequest(
            name = "보나",
            petType = PetType.DOG,
        )
        val memberId = 1L
        val petId = petService.createPet(request, memberId)

        // when
        val result = petService.getPet(petId)

        // then
        assertSoftly {
            it.assertThat(result).isNotNull
            it.assertThat(result.id).isEqualTo(1L)
            it.assertThat(result.id).isEqualTo(petId)
            it.assertThat(result.name).isEqualTo(request.name)
            it.assertThat(result.petType).isEqualTo(request.petType)
        }
    }
}
