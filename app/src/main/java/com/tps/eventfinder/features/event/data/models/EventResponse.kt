package com.tps.eventfinder.features.event.data.models

import com.squareup.moshi.Json

data class EventResponse(
    @field:Json(name = "_embedded")
    val embedded: EmbeddedEvents?
)

data class EmbeddedEvents(
    @field:Json(name = "events")
    val events: List<EventDto>
)