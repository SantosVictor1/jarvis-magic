package br.com.jarvis.magic.application.controller

import br.com.jarvis.magic.api.NicknameRequest
import br.com.jarvis.magic.api.PlayerApi
import br.com.jarvis.magic.api.PlayerResponse
import br.com.jarvis.magic.api.ResponseWrapper
import br.com.jarvis.magic.service.IPlayerService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class PlayerController(
    private val playerService: IPlayerService
) : PlayerApi {

    override fun login(@RequestBody @Valid nicknameRequest: NicknameRequest): ResponseWrapper<PlayerResponse> =
        ResponseWrapper(playerService.create(nicknameRequest.toDomain()).toResponse())

    override fun update(
        @RequestBody @Valid nicknameRequest: NicknameRequest,
        @PathVariable id: String
    ): ResponseWrapper<PlayerResponse> =
        ResponseWrapper(playerService.update(nicknameRequest.toDomain(), id).toResponse())
}