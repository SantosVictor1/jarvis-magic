package br.com.jarvis.magic.service.player.mapper

import br.com.jarvis.magic.domain.model.PlayerEntity
import br.com.jarvis.magic.domain.to.PlayerTO

fun PlayerTO.toEntity() = playerEntity(playerTO = this)

fun playerEntity(playerTO: PlayerTO): PlayerEntity =
    PlayerEntity(
        id = playerTO.id,
        nickname = playerTO.nickname,
        life = playerTO.life,
        mana = playerTO.mana
    )