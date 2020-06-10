package br.com.jarvis.magic.api

data class ResponseWrapper<T> (
    val content: T
)