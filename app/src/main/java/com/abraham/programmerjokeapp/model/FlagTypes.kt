package com.abraham.programmerjokeapp.model

import kotlinx.serialization.Serializable

@Serializable
data class FlagTypes(
    val nsfw: Boolean,
    val religious: Boolean,
    val political: Boolean,
    val racist: Boolean,
    val sexist: Boolean,
    val explicit: Boolean
)
