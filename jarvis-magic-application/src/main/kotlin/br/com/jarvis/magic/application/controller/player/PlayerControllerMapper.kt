package br.com.jarvis.magic.application.controller.player

import br.com.jarvis.magic.api.player.request.CreatePlayerRequest
import br.com.jarvis.magic.api.player.response.PlayerResponse
import br.com.jarvis.magic.domain.to.PlayerTO

fun CreatePlayerRequest.toDomain() = PlayerTO(nickname = this.nickname)

fun PlayerTO.toResponse() =
    PlayerResponse(
        id = this.id,
        nickname = this.nickname,
        life = this.life,
        mana = this.mana
    )
