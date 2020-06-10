package br.com.jarvis.magic.domain.model

import org.hibernate.annotations.GenericGenerator
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "player")
data class PlayerEntity (
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String = UUID.randomUUID().toString(),
    val nickname: String = "",
    val life: Int = 20,
    val mana: Int = 20,
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "player_deck",
        joinColumns = [JoinColumn(name = "player_id")],
        inverseJoinColumns = [JoinColumn(name = "card_id")]
    )
    private val cards: List<PlayerCardEntity> = listOf()
)

@Entity
@Table(name = "machine")
data class MachineEntity(
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String = UUID.randomUUID().toString(),
    val life: Int = 20,
    val mana: Int = 20
)

@Entity
@Table(name = "player_card")
data class PlayerCardEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    val title: String = "",
    val description: String = "",
    val cost: Int = 0,
    val lifeDamage: Int = 0,
    val passive: Int? = null
)

@Entity
@Table(name = "machine_card")
data class MachineCardEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    val title: String = "",
    val description: String = "",
    val cost: Int = 0,
    val lifeDamage: Int = 0,
    val manaDamage: Int? = null,
    @ManyToOne(targetEntity = MachineEntity::class)
    @JoinColumn(name = "machine_id", nullable = true)
    private val machine: MachineEntity? = null
)