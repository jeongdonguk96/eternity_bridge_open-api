package com.eternity_bridge.open_api.pet.repository

import com.eternity_bridge.open_api.pet.dto.CreatePetRequest

interface PetRepositoryQuerydsl {
    fun existsDuplicatedPet(request: CreatePetRequest, memberId: Long): Boolean
}