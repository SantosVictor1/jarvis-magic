package br.com.jarvis.magic.domain.model

import org.hibernate.annotations.GenericGenerator
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
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
    val mana: Int = 20
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
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String = UUID.randomUUID().toString(),
    val title: String = "",
    val description: String = "",
    val cost: Int = 0,
    val lifeDamage: Int = 0,
    val passive: Int? = null,
    @ManyToOne(targetEntity = PlayerEntity::class)
    @JoinColumn(name = "player_id", nullable = true)
    private val player: PlayerEntity? = null
)

@Entity
@Table(name = "machine_card")
data class MachineCardEntity(
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String = UUID.randomUUID().toString(),
    val title: String = "",
    val description: String = "",
    val cost: Int = 0,
    val lifeDamage: Int = 0,
    val manaDamage: Int? = null,
    @ManyToOne(targetEntity = MachineEntity::class)
    @JoinColumn(name = "machine_id", nullable = true)
    private val machine: MachineEntity? = null
)