package com.tps.eventfinder.features.event.data.datasources.remote

import com.tps.eventfinder.features.event.data.models.EventDto
import com.tps.eventfinder.features.event.data.models.EventResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface EventRemoteDataSource {
    @GET("/discovery/v2/events")
    suspend fun getEvents(
        @Query("apikey") apiKey: String,
        @Query("page") page: Int
    ): EventResponse

    @GET("/discovery/v2/events/{id}")
    suspend fun getEventDetail(
        @retrofit2.http.Path("id") id: String,
        @Query("apikey") apiKey: String
    ): EventDto
}


