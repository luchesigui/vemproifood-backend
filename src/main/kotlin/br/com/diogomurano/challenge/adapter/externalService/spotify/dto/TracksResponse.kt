package br.com.diogomurano.challenge.adapter.externalService.spotify.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class TracksResponse(
    @field:JsonProperty("items")
    val items: List<TrackParent>?
)

data class TrackParent(
    @field:JsonProperty("track")
    val track: Track?
)

data class Track(

    @field:JsonProperty("name")
    val name: String?,
    @field:JsonProperty("artists")
    val artists: List<Artist>?,
    @field:JsonProperty("duration_ms")
    val duration: Long?

)

data class Artist(
    @field:JsonProperty
    val name: String?
)
