package br.com.jarvis.magic.domain.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name = "player")
data class PlayerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "player_sequence", sequenceName = "player_sequence", allocationSize = 1)
    val id: Int? = null,
    val nickname: String = "",
    val life: Int = 20,
    val mana: Int = 20
)