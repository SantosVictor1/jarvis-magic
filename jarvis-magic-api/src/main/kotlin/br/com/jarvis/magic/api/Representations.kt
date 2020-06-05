package br.com.jarvis.magic.api

import javax.validation.constraints.NotEmpty

data class LoginRequest(
    @field:[NotEmpty]
    val nickname: String
)

data class PlayerResponse(
    val id: Int,
    val nickname: String,
    val life: Int,
    val mana: Int
)

data class ResponseWrapper<T> (
    val content: T
)