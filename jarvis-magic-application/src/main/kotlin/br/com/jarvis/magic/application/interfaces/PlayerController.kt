package br.com.jarvis.magic.application.interfaces

import br.com.jarvis.magic.api.PlayerApi
import br.com.jarvis.magic.api.PlayerRequest
import br.com.jarvis.magic.api.ResponseWrapper
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class PlayerController : PlayerApi {

    override fun login(@RequestBody @Valid playerRequest: PlayerRequest): ResponseWrapper<String> =
        ResponseWrapper(playerRequest.nickname)
}