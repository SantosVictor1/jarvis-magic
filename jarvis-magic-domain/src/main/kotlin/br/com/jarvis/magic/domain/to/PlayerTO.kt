package br.com.jarvis.magic.domain.to

data class PlayerTO(
    val id: Int? = null,
    val nickname: String = "",
    val life: Int = 20,
    val mana: Int = 20
)