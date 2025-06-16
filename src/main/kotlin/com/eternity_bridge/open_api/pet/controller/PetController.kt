package com.eternity_bridge.open_api.pet.controller

import com.eternity_bridge.open_api.common.dto.SingleResponse
import com.eternity_bridge.open_api.common.service.ResponseService
import com.eternity_bridge.open_api.pet.dto.CreatePetRequest
import com.eternity_bridge.open_api.pet.service.PetService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/pets")
class PetController(
    private val petService: PetService,
    private val responseService: ResponseService,
) {

    @PostMapping
    fun createPet(
        @RequestBody request: CreatePetRequest
    ): SingleResponse<Long> {
        val memberId = 1L
        return responseService.getSingleResponse(petService.createPet(request, memberId))
    }

}