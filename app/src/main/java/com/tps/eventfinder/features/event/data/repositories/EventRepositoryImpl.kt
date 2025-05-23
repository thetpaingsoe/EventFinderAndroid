package com.tps.eventfinder.features.event.data.repositories

import com.tps.eventfinder.core.config.Config
import com.tps.eventfinder.features.event.data.datasources.remote.EventRemoteDataSource
import com.tps.eventfinder.features.event.data.models.toDomain
import com.tps.eventfinder.features.event.domain.entities.Event
import com.tps.eventfinder.features.event.domain.repositories.EventRepository
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(
    private val api: EventRemoteDataSource
) : EventRepository {

    override suspend fun getEvents(page: Int): List<Event> {
        val response = api.getEvents(apiKey = Config.API_KEY, page = page)
        return response.embedded?.events?.map { it.toDomain() } ?: emptyList()
    }

    override suspend fun getEventDetail(id: String): Event {
        return Event(id = "0", name = "", imageUrl = "");
//        return api.getEventDetail(id = id, apiKey = API_KEY).toDomain()
    }


}