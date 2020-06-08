package br.com.jarvis.magic.service

import br.com.jarvis.magic.domain.to.PlayerTO

interface IPlayerService {

    fun create(playerTO: PlayerTO): PlayerTO

    fun update(playerTO: PlayerTO, id: String): PlayerTO
}