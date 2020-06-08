package br.com.jarvis.magic.application.exception

import br.com.jarvis.magic.infrastructure.error.ErrorMessageRepresentation
import br.com.jarvis.magic.infrastructure.error.JMErrorCode
import br.com.jarvis.magic.infrastructure.exception.PlayerNotFoundException
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class JarvisMagicExceptionHandler(
    private val messageSource: MessageSource
) {

    @ExceptionHandler(PlayerNotFoundException::class)
    @ResponseStatus(NOT_FOUND)
    @ResponseBody
    fun handlePlayerNotFoundException(ex: PlayerNotFoundException): ErrorMessageRepresentation =
        ErrorMessageRepresentation(
            message = getMessage(JMErrorCode.PLAYER_NOT_FOUND.key)
                ?: JMErrorCode.PLAYER_NOT_FOUND.code,
            code = JMErrorCode.PLAYER_NOT_FOUND.code
        )


    private fun getMessage(key: String): String? =
        messageSource.getMessage(key, null, LocaleContextHolder.getLocale())
}