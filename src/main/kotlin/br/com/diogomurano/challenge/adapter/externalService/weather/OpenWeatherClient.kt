package br.com.diogomurano.challenge.adapter.externalService.weather

import br.com.diogomurano.challenge.adapter.externalService.ServerErrorRetryPredicate
import br.com.diogomurano.challenge.adapter.externalService.weather.dto.OpenWeatherTemperatureResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.client.annotation.Client
import io.micronaut.retry.annotation.Retryable

@Client(
    value = "\${weather.client.url}",
    path = "\${weather.client.path}"
)
@Retryable(
    attempts = "\${weather.client.retry.attempts}",
    delay = "\${weather.client.retry.delay}",
    multiplier = "2.0",
    predicate = ServerErrorRetryPredicate::class
)
interface OpenWeatherClient {

    @Get("weather?q={cityName}&appid=$OPEN_WEATHER_KEY")
    fun findByCityName(
        @PathVariable cityName: String
    ): HttpResponse<OpenWeatherTemperatureResponse>

    @Get("weather?lat={lat}&lon={lon}&appid=$OPEN_WEATHER_KEY")
    fun findByCoordinates(
        @PathVariable lat: Double,
        @PathVariable lon: Double
    ): HttpResponse<OpenWeatherTemperatureResponse>

    companion object {
        const val OPEN_WEATHER_KEY: String = "\${weather.client.apikey}"
    }
}
