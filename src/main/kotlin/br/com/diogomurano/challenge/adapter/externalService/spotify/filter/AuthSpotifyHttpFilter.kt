package br.com.diogomurano.challenge.adapter.externalService.spotify.filter

import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpRequest
import io.micronaut.http.annotation.Filter
import io.micronaut.http.filter.ClientFilterChain
import io.micronaut.http.filter.HttpClientFilter
import org.reactivestreams.Publisher

@Filter("\${spotify.api.client.url}")
class AuthSpotifyHttpFilter(
    private val spotifyAuthClient: SpotifyAuthClient
): HttpClientFilter {

    override fun doFilter(request: MutableHttpRequest<*>, chain: ClientFilterChain): Publisher<out HttpResponse<*>> {
        val authToken = spotifyAuthClient.authWithClientIdAndClientSecret("", mapOf()).body()!!
        request.headers.add("authorization", "${authToken.type} ${authToken.accessToken}")
        return chain.proceed(request)
    }
}