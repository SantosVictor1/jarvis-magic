package br.com.jarvis.magic.application.controller.player

import br.com.jarvis.magic.api.ResponseWrapper
import br.com.jarvis.magic.api.player.PlayerApi
import br.com.jarvis.magic.api.player.request.CreatePlayerRequest
import br.com.jarvis.magic.api.player.response.PlayerResponse
import br.com.jarvis.magic.service.IPlayerService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PlayerController(
    private val playerService: IPlayerService
) : PlayerApi {

    override fun create(
        @RequestBody @Validated createPlayerRequest: CreatePlayerRequest
    ): ResponseWrapper<PlayerResponse> =
        ResponseWrapper(playerService.create(createPlayerRequest.toDomain()).toResponse())

    override fun update(
        @RequestBody @Validated createPlayerRequest: CreatePlayerRequest,
        @PathVariable(value = "id") id: String
    ): ResponseWrapper<PlayerResponse> =
        ResponseWrapper(playerService.update(createPlayerRequest.toDomain(), id).toResponse())

    override fun get(@PathVariable(value = "id") id: String): ResponseWrapper<PlayerResponse> =
        ResponseWrapper(playerService.getById(id).toResponse())
}