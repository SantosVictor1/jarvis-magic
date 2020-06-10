package br.com.jarvis.magic.api.player.response

import io.swagger.annotations.ApiModelProperty

data class PlayerNotFoundErrorResponse (

    @ApiModelProperty(example = "PLAYER_NOT_FOUND")
    val code: String,
    @ApiModelProperty(example = "Player not found client not found for ID informed.")
    val message: String
)