package br.com.jarvis.magic.application.controller

import br.com.jarvis.magic.api.LoginRequest
import br.com.jarvis.magic.api.PlayerResponse
import br.com.jarvis.magic.domain.to.PlayerTO

fun LoginRequest.toDomain() = PlayerTO(nickname = this.nickname)

fun PlayerTO.toResponse() =
    PlayerResponse(
        id = this.id,
        nickname = this.nickname,
        life = this.life,
        mana = this.mana
    )
