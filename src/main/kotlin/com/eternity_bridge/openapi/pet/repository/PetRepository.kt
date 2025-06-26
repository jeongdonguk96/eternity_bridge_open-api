package com.eternity_bridge.openapi.pet.repository

import com.eternity_bridge.openapi.pet.entity.Pet
import org.springframework.data.jpa.repository.JpaRepository

interface PetRepository : JpaRepository<Pet, Long>, PetRepositoryQuerydsl {
}