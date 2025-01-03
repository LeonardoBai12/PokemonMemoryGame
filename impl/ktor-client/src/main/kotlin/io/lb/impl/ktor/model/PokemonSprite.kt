package io.lb.impl.ktor.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class PokemonSprite(
    @SerialName("front_default")
    val url: String
)
