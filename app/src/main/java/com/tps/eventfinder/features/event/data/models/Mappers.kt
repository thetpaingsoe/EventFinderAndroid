package com.tps.eventfinder.features.event.data.models

import com.tps.eventfinder.features.event.domain.entities.Event

fun EventDto.toDomain(): Event {
    return Event(
        id = id,
        name = name,
        imageUrl = images?.firstOrNull()?.url
    )
}
