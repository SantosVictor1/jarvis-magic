package br.com.jarvis.magic.api

import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import javax.validation.Valid

interface PlayerApi {

    @PostMapping(path = ["/login"])
    @ResponseStatus(OK)
    @ResponseBody
    fun login(@RequestBody @Valid playerRequest: PlayerRequest): ResponseWrapper<String>
}