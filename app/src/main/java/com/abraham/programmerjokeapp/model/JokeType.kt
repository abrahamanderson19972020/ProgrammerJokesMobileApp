package com.abraham.programmerjokeapp.model

import kotlinx.serialization.Serializable

@Serializable
enum class JokeType{
    single,
    twopart
}