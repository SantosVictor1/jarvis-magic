package br.com.jarvis.magic.api

import javax.validation.constraints.NotEmpty

data class LoginRequest(
    @field:[NotEmpty]
    val nickname: String
)


data class ResponseWrapper<T> (
    val content: T
)