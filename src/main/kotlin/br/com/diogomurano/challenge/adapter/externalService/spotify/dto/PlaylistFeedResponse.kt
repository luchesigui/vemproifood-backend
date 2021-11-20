package br.com.diogomurano.challenge.adapter.externalService.spotify.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class PlaylistFeedResponse(
    @field:JsonProperty("playlists")
    val playlists: PlaylistParent?,
)

data class PlaylistParent(
    @field:JsonProperty("items")
    val items: List<Playlist>?
)

data class Playlist(
    @field:JsonProperty("id")
    val id: String?,

    @field:JsonProperty("name")
    val name: String?
)
