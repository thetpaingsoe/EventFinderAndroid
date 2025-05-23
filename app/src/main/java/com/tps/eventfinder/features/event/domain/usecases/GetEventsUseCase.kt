package com.tps.eventfinder.features.event.domain.usecases

import com.tps.eventfinder.features.event.domain.entities.Event
import com.tps.eventfinder.features.event.domain.repositories.EventRepository
import javax.inject.Inject

class GetEventsUseCase @Inject constructor(
    private val repository: EventRepository
) {
    suspend operator fun invoke(page: Int): List<Event> {
        return repository.getEvents(page)
    }
}