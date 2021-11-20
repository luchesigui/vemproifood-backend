package br.com.diogomurano.challenge.adapter.externalService.weather.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

data class OpenWeatherTemperatureResponse(
    @field:JsonProperty("main")
    val main: OpenWeatherTemperatureParent?
) {
    data class OpenWeatherTemperatureParent(
        @field:JsonProperty("temp")
        val temperature: BigDecimal?,
    )
}