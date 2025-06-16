package com.eternity_bridge.open_api.exception.code

enum class PetErrorCode(
    override var code: Int,
    override var message: String,
) : CommonErrorCode {
    PET_NOT_FOUND(400, "해당 반려동물을 찾을 수 없습니다."),
    DUPLICATED_PET(400, "이미 등록되어 있는 반려동물입니다."),
    MEMBER_HAS_NO_PETS(400, "보유한 반려동물이 없습니다."),
}