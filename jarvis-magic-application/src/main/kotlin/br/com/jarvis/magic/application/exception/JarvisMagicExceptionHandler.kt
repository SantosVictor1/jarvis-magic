package br.com.jarvis.magic.application.exception

import br.com.jarvis.magic.infrastructure.error.ErrorMessageRepresentation
import br.com.jarvis.magic.infrastructure.error.FieldsErrorCode
import br.com.jarvis.magic.infrastructure.error.JMErrorCode
import br.com.jarvis.magic.infrastructure.exception.PlayerNotFoundException
import org.apache.logging.log4j.LogManager
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.LinkedList

@ControllerAdvice
class JarvisMagicExceptionHandler(
    private val messageSource: MessageSource
) {

    private val log = LogManager.getLogger(this.javaClass)

    @ExceptionHandler(Exception::class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ResponseBody
    fun genericException(ex: Exception): ErrorMessageRepresentation {
        val code = JMErrorCode.GENERAL_ERROR.code
        val originalError = ex.javaClass.name + " - " + ex.message
        val message = getMessage(JMErrorCode.GENERAL_ERROR.key)

        log.error("Exception: {}", originalError, ex)

        return ErrorMessageRepresentation(
            code = code, message = message ?: code, originalError = originalError
        )
    }

    @ExceptionHandler(PlayerNotFoundException::class)
    @ResponseStatus(NOT_FOUND)
    @ResponseBody
    fun handlePlayerNotFoundException(ex: PlayerNotFoundException): ErrorMessageRepresentation {
        log.error("PlayerNotFoundException: {}", ex)

        return ErrorMessageRepresentation(
            message = getMessage(JMErrorCode.PLAYER_NOT_FOUND.key)
                ?: JMErrorCode.PLAYER_NOT_FOUND.code,
            code = JMErrorCode.PLAYER_NOT_FOUND.code
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException): ErrorMessageRepresentation {
        val fields = LinkedHashMap<String, List<String>>()

        log.error("MethodArgumentNotValidException ", ex)

        ex.bindingResult.fieldErrors.forEach { field ->
            fields.computeIfAbsent(field.field) {
                LinkedList<String>().also { f ->
                    when (field.code) {
                        ("NotNull") -> f.add(FieldsErrorCode.MUST_NOT_BE_NULL.code)
                        ("NotBlank") -> f.add(FieldsErrorCode.MUST_NOT_BE_BLANK.code)
                        ("NotEmpty") -> f.add(FieldsErrorCode.MUST_NOT_BE_EMPTY.code)
                        ("Size") -> f.add(FieldsErrorCode.INCORRECT_SIZE.code)
                        else -> f.add(FieldsErrorCode.METHOD_ARGUMENT_INVALID.code)
                    }
                }
            }
        }

        return ErrorMessageRepresentation(
            fields = fields,
            message = getMessage(JMErrorCode.METHOD_ARGUMENT_INVALID.key)
                ?: JMErrorCode.METHOD_ARGUMENT_INVALID.code,
            code = JMErrorCode.METHOD_ARGUMENT_INVALID.code
        )
    }


    private fun getMessage(key: String): String? =
        messageSource.getMessage(key, null, LocaleContextHolder.getLocale())
}