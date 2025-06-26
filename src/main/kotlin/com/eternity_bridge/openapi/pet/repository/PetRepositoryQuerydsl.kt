package com.eternity_bridge.openapi.pet.repository

import com.eternity_bridge.openapi.pet.dto.CreatePetRequest

interface PetRepositoryQuerydsl {
    fun existsDuplicatedPet(request: CreatePetRequest, memberId: Long): Boolean
}