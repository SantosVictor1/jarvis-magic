package br.com.jarvis.magic.application.controller

import br.com.jarvis.magic.api.LoginRequest
import br.com.jarvis.magic.api.PlayerApi
import br.com.jarvis.magic.api.PlayerResponse
import br.com.jarvis.magic.api.ResponseWrapper
import br.com.jarvis.magic.service.player.PlayerService
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class PlayerController(
    private val playerService: PlayerService
) : PlayerApi {

    override fun login(@RequestBody @Valid loginRequest: LoginRequest): ResponseWrapper<PlayerResponse> =
        ResponseWrapper(playerService.create(loginRequest.toDomain()).toResponse())
}