package com.eternity_bridge.openapi.pet.repository

import com.eternity_bridge.openapi.pet.dto.CreatePetRequest
import com.eternity_bridge.openapi.pet.entity.QPet.pet
import com.querydsl.jpa.impl.JPAQueryFactory

class PetRepositoryQuerydslImpl (
    private val queryFactory: JPAQueryFactory
) : PetRepositoryQuerydsl {

    override fun existsDuplicatedPet(
        request: CreatePetRequest,
        memberId: Long
    ): Boolean {
        return queryFactory.selectOne()
            .from(pet)
            .where(pet.name.eq(request.name)
                .and(pet.memberId.eq(memberId)))
            .fetchFirst() != null
    }


}