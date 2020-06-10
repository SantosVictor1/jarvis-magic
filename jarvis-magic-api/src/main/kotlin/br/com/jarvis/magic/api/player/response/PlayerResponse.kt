package br.com.jarvis.magic.api.player.response

data class PlayerResponse(
    val id: String,
    val nickname: String,
    val life: Int,
    val mana: Int
)
