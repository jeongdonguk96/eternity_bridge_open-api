package com.eternity_bridge.openapi.pet.service

import com.eternity_bridge.openapi.exception.code.PetErrorCode
import com.eternity_bridge.openapi.exception.exception.CommonException
import com.eternity_bridge.openapi.pet.dto.CreatePetRequest
import com.eternity_bridge.openapi.pet.entity.Pet
import com.eternity_bridge.openapi.pet.factory.PetFactory
import com.eternity_bridge.openapi.pet.repository.PetRepository
import io.github.oshai.kotlinlogging.KotlinLogging
import org.slf4j.MDC
import org.springframework.stereotype.Service

private val log = KotlinLogging.logger {}

@Service
class PetService(
    private val petRepository: PetRepository
) {

    fun createPet(
       request: CreatePetRequest,
       memberId: Long
    ): Long {
        val trxId = MDC.get("trxId")

        checkDuplicatedPet(request, memberId, trxId)
        val pet = petRepository.save(PetFactory.from(memberId, request))
        log.info { "[$trxId] 반려동물 등록 성공" }

        return pet.id!!
    }


    fun getPet(petId: Long): Pet {
        return petRepository.findById(petId)
            .orElseThrow { CommonException(PetErrorCode.PET_NOT_FOUND) }
    }


    private fun checkDuplicatedPet(
        request: CreatePetRequest,
        memberId: Long,
        trxId: String
    ) {
        if (petRepository.existsDuplicatedPet(request, memberId)) {
            log.info { "[$trxId] 반려동물 등록 전 중복체크 결과 => 중복있음" }
            throw CommonException(PetErrorCode.DUPLICATED_PET)
        }

        log.info { "[$trxId] 반려동물 등록 전 중복체크 결과 => 중복없음" }
    }

}