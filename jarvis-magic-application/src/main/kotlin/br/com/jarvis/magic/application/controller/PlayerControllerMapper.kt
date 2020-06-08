package br.com.jarvis.magic.application.controller

import br.com.jarvis.magic.api.NicknameRequest
import br.com.jarvis.magic.api.PlayerResponse
import br.com.jarvis.magic.domain.to.PlayerTO

fun NicknameRequest.toDomain() = PlayerTO(nickname = this.nickname)

fun PlayerTO.toResponse() =
    PlayerResponse(
        id = this.id,
        nickname = this.nickname,
        life = this.life,
        mana = this.mana
    )
