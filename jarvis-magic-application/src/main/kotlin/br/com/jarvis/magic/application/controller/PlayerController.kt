package br.com.jarvis.magic.application.controller

import br.com.jarvis.magic.api.LoginRequest
import br.com.jarvis.magic.api.PlayerApi
import br.com.jarvis.magic.api.ResponseWrapper
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class PlayerController : PlayerApi {

    override fun login(@RequestBody @Valid loginRequest: LoginRequest): ResponseWrapper<String> =
        ResponseWrapper(loginRequest.nickname)
}