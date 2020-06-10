package br.com.jarvis.magic.api.player.response

import io.swagger.annotations.ApiModelProperty

data class EmptyNicknameFieldErrorResponse(

    @ApiModelProperty(example = "EMPTY_FIELD")
    val code: String,
    @ApiModelProperty(example = "Empty field.")
    val message: String
)