package com.tps.eventfinder.features.event.presentation.event_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tps.eventfinder.features.event.domain.entities.Event
import com.tps.eventfinder.features.event.domain.usecases.GetEventsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventListViewModel @Inject constructor(
    private val getEventsUseCase: GetEventsUseCase
) : ViewModel() {

    var state by mutableStateOf<EventListState>(EventListState.Loading)
        private set

    init {
        fetchEvents()
    }

    fun fetchEvents(keyword: String? = null) {
        viewModelScope.launch {
            state = EventListState.Loading
            try {
                val events = getEventsUseCase(1)
                state = EventListState.Success(events)
            } catch (e: Exception) {
                state = EventListState.Error("Failed to load events")
            }
        }
    }
}

sealed class EventListState {
    object Loading : EventListState()
    data class Success(val events: List<Event>) : EventListState()
    data class Error(val message: String) : EventListState()
}