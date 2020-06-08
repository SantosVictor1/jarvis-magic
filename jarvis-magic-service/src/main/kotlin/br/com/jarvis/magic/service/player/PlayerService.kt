package br.com.jarvis.magic.service.player

import br.com.jarvis.magic.domain.to.PlayerTO
import br.com.jarvis.magic.infrastructure.exception.PlayerNotFoundException
import br.com.jarvis.magic.repository.PlayerRepository
import br.com.jarvis.magic.service.IPlayerService
import br.com.jarvis.magic.service.player.mapper.toEntity
import br.com.jarvis.magic.service.player.mapper.toTO
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.function.Supplier

@Service
class PlayerService(
    private val playerRepository: PlayerRepository
): IPlayerService {

    private val log: Logger = LoggerFactory.getLogger(PlayerService::class.java)

    override fun create(playerTO: PlayerTO): PlayerTO {
        val player = playerRepository.save(playerTO.toEntity())

        log.info("Player created: $player")

        return player.toTO()
    }

    override fun update(playerTO: PlayerTO, id: String): PlayerTO {
        val player = playerRepository.findById(id).orElseThrow{ PlayerNotFoundException() }

        val playerUpdated = playerRepository.save(player.copy(nickname = playerTO.nickname))

        log.info("Player updated: $playerUpdated")

        return playerUpdated.toTO()
    }
}