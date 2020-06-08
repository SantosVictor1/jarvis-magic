package br.com.jarvis.magic.domain.model

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "player")
data class PlayerEntity (
    @Id
    val id: String = UUID.randomUUID().toString(),
    val nickname: String = "",
    val life: Int = 20,
    val mana: Int = 20
)

@Entity
@Table(name = "player_card")
data class PlayerCardEntity(
    @Id
    val id: String = UUID.randomUUID().toString(),
    val title: String = "",
    val description: String = "",
    val cost: Int = 0,
    val lifeDamage: Int = 0,
    val passive: Int = 0,
    @ManyToOne(targetEntity = PlayerEntity::class)
    @JoinColumn(name = "player_id", nullable = true)
    private val player: PlayerEntity? = null
)