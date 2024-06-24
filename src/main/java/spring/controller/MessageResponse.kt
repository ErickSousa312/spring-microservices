package spring.controller

import kotlinx.serialization.Serializable

@Serializable
data class MessageResponse<Person>(
    val message: String,
    val data: Person? = null
)