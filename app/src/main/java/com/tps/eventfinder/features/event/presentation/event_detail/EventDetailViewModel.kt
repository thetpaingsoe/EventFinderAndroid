package com.tps.eventfinder.features.event.presentation.event_detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tps.eventfinder.features.event.domain.entities.Event
import com.tps.eventfinder.features.event.domain.usecases.GetEventDetailUseCase
import com.tps.eventfinder.features.event.presentation.event_list.EventListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventDetailViewModel @Inject constructor(
    private val getEventDetailUseCase: GetEventDetailUseCase
) : ViewModel() {
    var state by mutableStateOf<EventState>(EventState.Loading)
        private set

//    init {
//        fetchEvent()
//    }

    fun fetchEvent(id: String) {
        viewModelScope.launch {
            state = EventState.Loading
            try {
                val events = getEventDetailUseCase(id)
                state = EventState.Success(events)
            } catch (e: Exception) {
                state = EventState.Error("Failed to load events")
            }
        }
    }

//    fun loadEvent(id: String) {
//        viewModelScope.launch {
//            event = getEventDetailUseCase(id)
//        }
//    }
}

sealed class EventState {
    object Loading : EventState()
    data class Success(val event: Event) : EventState()
    data class Error(val message: String) : EventState()
}