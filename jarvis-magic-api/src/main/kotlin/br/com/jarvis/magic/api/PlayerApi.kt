package br.com.jarvis.magic.api

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import javax.validation.Valid

@Api(value="Session Command", tags=["Session Command"], description="Session Command Resources")
interface PlayerApi {

    @PostMapping(value = ["/v1/login"])
    @ResponseStatus(OK)
    @ResponseBody
    @ApiOperation(value = "Login with nickname")
    @ApiResponses(value = [
        ApiResponse(code = 200, message = "Login succeeded")
    ])
    fun login(@RequestBody @Valid playerRequest: PlayerRequest): ResponseWrapper<String>
}