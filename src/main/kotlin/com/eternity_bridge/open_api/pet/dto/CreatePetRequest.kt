package com.eternity_bridge.open_api.pet.dto

import com.eternity_bridge.open_api.pet.entity.Pet
import com.eternity_bridge.open_api.pet.enums.PetType

data class CreatePetRequest(
    val name: String,
    val nickname: String?,
    val petType: PetType,
    val birthDate: String,
    val deathDate: String,
    val profileImageUrl: String,
) {

    fun toPet(
        memberId: Long
    ): Pet {
        return Pet(
            name = this.name,
            nickname = nickname,
            petType = this.petType,
            birthDate = this.birthDate,
            deathDate = this.deathDate,
            profileImageUrl = this.profileImageUrl,
            dotImageUrl = null,
            memberId = memberId,
        )
    }

}

