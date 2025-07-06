package com.abraham.programmerjokeapp.model

import kotlinx.serialization.Serializable

@Serializable
data class Joke(
    val error: Boolean,
    val category: String,
    val type: JokeType,
    val setup: String? = null,
    val delivery: String? = null,
    val joke: String? = null,
    val flags: FlagTypes,
    val id: Int,
    val safe: Boolean,
    val lang: String
)

