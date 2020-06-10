package br.com.jarvis.magic.repository

import br.com.jarvis.magic.domain.model.PlayerCardEntity
import br.com.jarvis.magic.domain.model.PlayerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerRepository : JpaRepository<PlayerEntity, String>

@Repository
interface PlayerCardRepository : JpaRepository<PlayerCardEntity, Int>