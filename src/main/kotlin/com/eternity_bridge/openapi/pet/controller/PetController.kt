package com.eternity_bridge.openapi.pet.controller

import com.eternity_bridge.openapi.common.dto.SingleResponse
import com.eternity_bridge.openapi.common.service.ResponseService
import com.eternity_bridge.openapi.pet.dto.CreatePetRequest
import com.eternity_bridge.openapi.pet.entity.Pet
import com.eternity_bridge.openapi.pet.service.PetService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/pets")
class PetController(
    private val petService: PetService,
    private val responseService: ResponseService,
) : PetControllerSwagger {

    @PostMapping
    override fun createPet(
        @Valid @RequestBody request: CreatePetRequest
    ): SingleResponse<Long> {
        val memberId = 1L
        return responseService.getSingleResponse(petService.createPet(request, memberId))
    }


    @GetMapping("/{petId}")
    override fun getPet(
        @PathVariable(name = "petId") petId: Long,
    ): SingleResponse<Pet> {
        return responseService.getSingleResponse(petService.getPet(petId))
    }

}