package br.com.jarvis.magic.application.interfaces

import br.com.jarvis.magic.api.PlayerApi
import br.com.jarvis.magic.api.PlayerRequest
import br.com.jarvis.magic.api.ResponseWrapper
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class PlayerController : PlayerApi {

    override fun login(@RequestBody @Valid playerRequest: PlayerRequest): ResponseWrapper<String> =
        ResponseWrapper(playerRequest.nickname)
}