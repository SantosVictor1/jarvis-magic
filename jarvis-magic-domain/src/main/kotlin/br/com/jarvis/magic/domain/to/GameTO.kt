package br.com.jarvis.magic.domain.to

import br.com.jarvis.magic.domain.GameMode

class GameTO (
    val nickname: String = "",
    val gameMode: GameMode = GameMode.SINGLE_PLAYER
)