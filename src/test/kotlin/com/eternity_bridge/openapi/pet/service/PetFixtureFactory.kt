import com.eternity_bridge.openapi.pet.dto.CreatePetRequest
import com.eternity_bridge.openapi.pet.enums.PetType
import com.navercorp.fixturemonkey.FixtureMonkey
import com.navercorp.fixturemonkey.kotlin.KotlinPlugin
import com.navercorp.fixturemonkey.kotlin.giveMeBuilder

object PetFixtureFactory {

    private val fixtureMonkey = FixtureMonkey.builder()
        .plugin(KotlinPlugin())
        .build()

    fun createPetRequest(
        name: String? = null,
        petType: PetType? = null
    ): CreatePetRequest {
        return fixtureMonkey.giveMeBuilder<CreatePetRequest>()
            .apply {
                name?.let { set("name", it) }
                petType?.let { set("petType", it) }
            }
            .sample()
    }

}
