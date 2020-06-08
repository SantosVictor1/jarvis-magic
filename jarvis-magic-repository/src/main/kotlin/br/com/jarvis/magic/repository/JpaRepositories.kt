package br.com.jarvis.magic.repository

import org.springframework.data.jpa.repository.JpaRepository
import br.com.jarvis.magic.domain.model.PlayerEntity
import org.springframework.stereotype.Repository

@Repository
interface PlayerRepository : JpaRepository<PlayerEntity, String> {

}