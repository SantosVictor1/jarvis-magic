package br.com.jarvis.magic.service.player.mapper

import br.com.jarvis.magic.domain.model.PlayerEntity
import br.com.jarvis.magic.domain.to.PlayerTO

fun PlayerEntity.toTO() = playerTO(playerEntity = this)

fun playerTO(playerEntity: PlayerEntity): PlayerTO =
    PlayerTO(
        id = playerEntity.id,
        nickname = playerEntity.nickname,
        life = playerEntity.life,
        mana = playerEntity.mana
    )