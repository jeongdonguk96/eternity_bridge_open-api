package com.eternity_bridge.open_api.pet.entity

import com.eternity_bridge.open_api.common.entity.BaseEntity
import com.eternity_bridge.open_api.pet.enums.PetType
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Pet(
    var name: String,
    var nickname: String?,
    @Enumerated(EnumType.STRING)
    var petType: PetType,
    var birthDate: String,
    var deathDate: String,
    var profileImageUrl: String,
    var dotImageUrl: String?,
    var memberId: Long,

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) : BaseEntity()