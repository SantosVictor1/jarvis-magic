package br.com.jarvis.magic.api.player

import br.com.jarvis.magic.api.ResponseWrapper
import br.com.jarvis.magic.api.player.request.CreatePlayerRequest
import br.com.jarvis.magic.api.player.response.EmptyNicknameFieldErrorResponse
import br.com.jarvis.magic.api.player.response.PlayerCreatedResponse
import br.com.jarvis.magic.api.player.response.PlayerNotFoundErrorResponse
import br.com.jarvis.magic.infrastructure.error.ErrorMessageRepresentation
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import javax.validation.Valid

@Api(value = "Player", tags = ["Player"], description = "Player Resources")
@RequestMapping("/player")
interface PlayerApi {

    @PostMapping(value = ["/create"], produces = ["application/json"])
    @ResponseStatus(CREATED)
    @ResponseBody
    @ApiOperation(value = "Create player")
    @ApiResponses(value = [
        ApiResponse(code = 201, message = "Created"),
        ApiResponse(code = 400, message = "Empty field.", response = EmptyNicknameFieldErrorResponse::class)
    ])
    fun create(@RequestBody @Valid createPlayerRequest: CreatePlayerRequest): ResponseWrapper<PlayerCreatedResponse>

    @PutMapping(value = ["/update/{id}"], produces = ["application/json"])
    @ResponseStatus(OK)
    @ResponseBody
    @ApiOperation(value = "Update player")
    @ApiResponses(value = [
        ApiResponse(code = 400, message = "Invalid field.", response = EmptyNicknameFieldErrorResponse::class),
        ApiResponse(code = 404, message = "Player not found.", response = PlayerNotFoundErrorResponse::class)
    ])
    fun update(
        @RequestBody @Valid createPlayerRequest: CreatePlayerRequest,
        @PathVariable(value = "id") id: String
    ): ResponseWrapper<PlayerCreatedResponse>
}