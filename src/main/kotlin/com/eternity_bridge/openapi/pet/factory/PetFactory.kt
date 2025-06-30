package com.eternity_bridge.openapi.pet.factory

import com.eternity_bridge.openapi.pet.dto.CreatePetRequest
import com.eternity_bridge.openapi.pet.entity.Pet

class PetFactory {

    companion object {
        fun from(
            memberId: Long,
            request: CreatePetRequest,
        ) : Pet {
            return Pet(
                name = request.name,
                nickname = request.nickname,
                petType = request.petType,
                birthDate = request.birthDate,
                deathDate = request.deathDate,
                profileImageUrl = request.profileImageUrl,
                dotImageUrl = null,
                memberId = memberId
            )
        }

    }

}
