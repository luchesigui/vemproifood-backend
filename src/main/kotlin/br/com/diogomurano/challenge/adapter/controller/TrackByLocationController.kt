package br.com.diogomurano.challenge.adapter.controller

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.QueryValue
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn

@Controller("/api/v1/tracks")
@ExecuteOn(TaskExecutors.IO)
class TrackByLocationController {

    fun findTracksByLocation(
        @QueryValue("city") city: String?,
        @QueryValue("latitude") latitude: Double?,
        @QueryValue("longitude") longitude: Double?,
    ): HttpResponse<*> {

        return HttpResponse.ok("")
    }

}