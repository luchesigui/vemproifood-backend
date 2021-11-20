package br.com.diogomurano.challenge.adapter.externalService.weather.dto

import com.fasterxml.jackson.annotation.JsonProperty
import org.valiktor.functions.isNotNull
import org.valiktor.validate
import java.math.BigDecimal

data class OpenWeatherTemperatureParent(

    @field:JsonProperty("temp")
    val temperature: BigDecimal?,

) {
    init {
        validate(this) {
            validate(OpenWeatherTemperatureParent::temperature).isNotNull()
        }
    }
}