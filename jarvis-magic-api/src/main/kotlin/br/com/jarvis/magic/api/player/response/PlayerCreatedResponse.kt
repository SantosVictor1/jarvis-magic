package br.com.jarvis.magic.api.player.response

data class PlayerCreatedResponse(
    val id: String,
    val nickname: String,
    val life: Int,
    val mana: Int
)
