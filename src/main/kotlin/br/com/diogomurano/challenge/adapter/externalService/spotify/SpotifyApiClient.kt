package br.com.diogomurano.challenge.adapter.externalService.spotify

import br.com.diogomurano.challenge.adapter.externalService.ServerErrorRetryPredicate
import br.com.diogomurano.challenge.adapter.externalService.spotify.dto.PlaylistFeedResponse
import br.com.diogomurano.challenge.adapter.externalService.spotify.dto.TracksResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.client.annotation.Client
import io.micronaut.retry.annotation.Retryable

@Client(
    value = "\${spotify.api.client.url}",
    path = "\${spotify.api.client.path}"
)
@Retryable(
    attempts = "\${spotify.account.client.retry.attempts}",
    delay = "\${spotify.account.client.retry.delay}",
    predicate = ServerErrorRetryPredicate::class,
    multiplier = "2.0"
)
interface SpotifyApiClient {

    @Get("search?q={trackType}&type=playlist&limit=1&offset=0")
    fun findPlaylistByTrackType(
        @Header authorization: String,
        @PathVariable trackType: TrackType,
    ): HttpResponse<PlaylistFeedResponse>

    @Get("playlists/{playlistId}/tracks?market=BR")
    fun findTracksByUrl(@Header authorization: String, @PathVariable playlistId: String): HttpResponse<TracksResponse>

}