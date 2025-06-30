package com.eternity_bridge.openapi.pet.dto

import com.eternity_bridge.openapi.pet.enums.PetType
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.AssertTrue
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Date

data class CreatePetRequest(
    @field:NotBlank(message = "이름은 필수입니다.")
    @field:Size(max = 20, message = "이름은 20자를 초과할 수 없습니다.")
    @Schema(
        description = "반려동물 이름",
        example = "초코",
        minLength = 1,
        maxLength = 20,
        required = true
    )
    val name: String,

    @field:Size(max = 20, message = "닉네임은 20자를 초과할 수 없습니다.")
    @Schema(
        description = "반려동물 별명",
        example = "찡찡이",
        required = false
    )
    val nickname: String?,

    @field:NotNull(message = "반려동물 종류는 필수입니다.")
    @Schema(
        description = "반려동물 종류",
        example = "DOG",
        allowableValues = ["DOG", "CAT", "ETC"],
        required = true
    )
    val petType: PetType,

    @field:NotBlank(message = "생년월일은 필수입니다.")
    @field:Pattern(
        regexp = "^\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$",
        message = "날짜는 YYYY-MM-DD 형식이어야 합니다."
    )
    @Schema(
        description = "생년월일 (YYYY-MM-DD)",
        example = "2020-08-02",
        required = true
    )
    val birthDate: String,

    @field:NotBlank(message = "사망일자는 필수입니다.")
    @field:Pattern(
        regexp = "^\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$",
        message = "날짜는 YYYY-MM-DD 형식이어야 합니다."
    )
    @Schema(
        description = "사망일자 (YYYY-MM-DD)",
        example = "2025-02-06",
        required = true,
    )
    val deathDate: String,

    @field:NotBlank(message = "프로필 이미지 URL은 필수입니다.")
    @field:Pattern(
        regexp = "^(https)://.*$",
        message = "올바른 URL 형식이어야 합니다."
    )
    @Schema(
        description = "프로필 이미지 URL",
        example = "https://example.com/profile.jpg",
        required = true
    )
    val profileImageUrl: String,
) {

    @AssertTrue(message = "생년월일은 오늘 이전이어야 합니다.")
    private fun isBirthDateValid(): Boolean {
        return LocalDate.parse(birthDate) <= LocalDate.now()
    }

    @AssertTrue(message = "사망일자는 생년월일과 같거나 이후여야 합니다.")
    private fun isDeathDateValid(): Boolean {
        return LocalDate.parse(birthDate) <= LocalDate.parse(deathDate)
    }

}

