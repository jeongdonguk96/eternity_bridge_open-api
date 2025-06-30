package com.eternity_bridge.openapi.pet.controller

import com.eternity_bridge.openapi.common.dto.SingleResponse
import com.eternity_bridge.openapi.pet.dto.CreatePetRequest
import com.eternity_bridge.openapi.pet.entity.Pet
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.ExampleObject
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping


@Tag(name = "반려동물", description = "반려동물 관련 API")
interface PetControllerSwagger {

    @Operation(summary = "반려동물 등록", description = "새로운 반려동물을 등록합니다.")
    @ApiResponses(
        value = [ApiResponse(
            responseCode = "200", description = "성공", content = [Content(
                mediaType = "application/json", examples = [ExampleObject(
                    value = """
                        {
                            "success": true,
                            "code": 200,
                            "message": "SUCCESS",
                            "validationErrors": null,
                            "data": 1
                        }
                        """
                )]
            )]
        ), ApiResponse(
            responseCode = "400",
            description = "잘못된 요청",
            content = [Content()]
        ), ApiResponse(responseCode = "500", description = "내부 서비스 에러", content = [Content()])]
    )
    @PostMapping
    fun createPet(
        request: CreatePetRequest
    ): SingleResponse<Long>

    @Operation(summary = "반려동물 조회", description = "반려동물 정보를 조회합니다.")
    @ApiResponses(
        value = [ApiResponse(responseCode = "200", description = "성공"), ApiResponse(
            responseCode = "400",
            description = "잘못된 요청",
            content = [Content()]
        ), ApiResponse(responseCode = "500", description = "내부 서비스 에러", content = [Content()])]
    )
    @GetMapping("/{petId}")
    fun getPet(
        @Parameter(description = "반려동물 ID", required = true) @PathVariable(name = "petId") petId: Long
    ): SingleResponse<Pet>

}