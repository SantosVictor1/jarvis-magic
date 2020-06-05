package br.com.jarvis.magic.api

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import javax.validation.Valid

@Api(value="Player Resource", tags=["Player Resource"], description="Player Command Resources")
@RequestMapping("/player")
interface PlayerApi {

    @PostMapping(value = ["/login"])
    @ResponseStatus(OK)
    @ResponseBody
    @ApiOperation(value = "Login with nickname")
    fun login(@RequestBody @Valid loginRequest: LoginRequest): ResponseWrapper<String>
}