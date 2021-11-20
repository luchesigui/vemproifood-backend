package br.com.diogomurano.challenge.adapter.externalService.spotify.filter

import br.com.diogomurano.challenge.adapter.externalService.ServerErrorRetryPredicate
import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client
import io.micronaut.retry.annotation.Retryable

@Client(
    value = "\${spotify.account.client.url}",
    path = "\${spotify.account.client.path}"
)
@Retryable(
    attempts = "\${spotify.account.client.retry.attempts}",
    delay = "\${spotify.account.client.retry.delay}",
    multiplier = "2.0",
    predicate = ServerErrorRetryPredicate::class
)
interface SpotifyAuthClient {
    @Post(produces = [MediaType.APPLICATION_FORM_URLENCODED])
    fun authWithClientIdAndClientSecret(
        @Header authorization: String,
        @Body body: Map<String, String>
    ): HttpResponse<SpotifyAccessTokenResponse>
}

data class SpotifyAccessTokenResponse(
    @field:JsonProperty("access_token")
    val accessToken: String?,

    @field:JsonProperty("token_type")
    val type: String?,
)