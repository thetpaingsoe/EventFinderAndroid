package com.tps.eventfinder.features.event.domain.repositories

import com.tps.eventfinder.features.event.domain.entities.Event

interface EventRepository {
    suspend fun getEvents(page: Int): List<Event>
    suspend fun getEventDetail(id: String): Event
}