package com.eternity_bridge.open_api.pet.repository

import com.eternity_bridge.open_api.pet.entity.Pet
import org.springframework.data.jpa.repository.JpaRepository

interface PetRepository : JpaRepository<Pet, Long>, PetRepositoryQuerydsl {
}