package br.com.jarvis.magic.infrastructure.error

class GeneralError(code: String, key: String) : ErrorCode(code, key)

object JMErrorCode {
    val GENERAL_ERROR: ErrorCode = GeneralError("GENERAL_ERROR", "general.error")
    val METHOD_ARGUMENT_INVALID: ErrorCode = GeneralError("METHOD_ARGUMENT_INVALID", "method.argument.invalid")
    val EMPTY_NICKNAME_FIELD = GeneralError("EMPTY_NICKNAME_FIELD", "empty.nickname.field")
    val PLAYER_NOT_FOUND = GeneralError("PLAYER_NOT_FOUND", "player.not.found")
}