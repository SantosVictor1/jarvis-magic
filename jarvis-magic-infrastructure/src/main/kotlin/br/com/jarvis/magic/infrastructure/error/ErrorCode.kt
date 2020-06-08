package br.com.jarvis.magic.infrastructure.error

data class ErrorCode(
    val code: String,
    val key: String
)

object JMErrorCode {
    val PLAYER_NOT_FOUND = ErrorCode("PLAYER_NOT_FOUND", "player.not.found")
}