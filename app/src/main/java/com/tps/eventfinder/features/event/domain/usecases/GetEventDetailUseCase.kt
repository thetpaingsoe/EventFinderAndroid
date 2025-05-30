package com.tps.eventfinder.features.event.domain.usecases

import com.tps.eventfinder.features.event.domain.entities.Event
import com.tps.eventfinder.features.event.domain.repositories.EventRepository
import javax.inject.Inject

class GetEventDetailUseCase @Inject constructor(
    private val repository: EventRepository
){
    suspend operator fun invoke(id : String): Event {
        return repository.getEventDetail(id)
    }
}