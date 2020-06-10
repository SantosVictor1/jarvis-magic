package br.com.jarvis.magic.api.player.request

import javax.validation.constraints.NotEmpty

data class CreatePlayerRequest (
    @field:[NotEmpty]
    val nickname: String
)