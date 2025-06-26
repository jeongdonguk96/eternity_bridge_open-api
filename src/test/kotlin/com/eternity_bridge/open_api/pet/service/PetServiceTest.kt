package com.eternity_bridge.open_api.pet.service

import com.eternity_bridge.open_api.common.AbstractTest
import com.eternity_bridge.open_api.pet.enums.PetType
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.slf4j.MDC
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PetServiceTest : AbstractTest(){

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
        assertTrue(petRepository.existsById(result))
        assertEquals(1L, petRepository.count())
        assertEquals(1L, result)
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
        assertEquals(1L, result.id)
        assertEquals(petId, result.id)
        assertEquals(request.name, result.name)
        assertEquals(request.petType, result.petType)
    }
}
