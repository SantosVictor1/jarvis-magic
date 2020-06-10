package br.com.jarvis.magic.application.controller.player

import br.com.jarvis.magic.api.ResponseWrapper
import br.com.jarvis.magic.api.player.PlayerApi
import br.com.jarvis.magic.api.player.request.CreatePlayerRequest
import br.com.jarvis.magic.api.player.response.PlayerCreatedResponse
import br.com.jarvis.magic.service.IPlayerService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PlayerController(
    private val playerService: IPlayerService
) : PlayerApi {

    override fun create(@RequestBody @Validated createPlayerRequest: CreatePlayerRequest): ResponseWrapper<PlayerCreatedResponse> =
        ResponseWrapper(playerService.create(createPlayerRequest.toDomain()).toResponse())

    override fun update(
        @RequestBody @Validated createPlayerRequest: CreatePlayerRequest,
        @PathVariable(value = "id") id: String
    ): ResponseWrapper<PlayerCreatedResponse> =
        ResponseWrapper(playerService.update(createPlayerRequest.toDomain(), id).toResponse())
}