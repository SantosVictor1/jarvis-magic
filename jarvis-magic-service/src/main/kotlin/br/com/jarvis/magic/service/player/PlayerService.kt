package br.com.jarvis.magic.service.player

import br.com.jarvis.magic.domain.to.PlayerTO
import br.com.jarvis.magic.repository.PlayerRepository
import br.com.jarvis.magic.service.player.mapper.toEntity
import br.com.jarvis.magic.service.player.mapper.toTO
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class PlayerService(
    private val playerRepository: PlayerRepository
) {

    private val logger: Logger = LoggerFactory.getLogger(PlayerService::class.java)

    fun create(playerTO: PlayerTO): PlayerTO {
        val player = playerRepository.save(playerTO.toEntity())

        return player.toTO()
    }
}