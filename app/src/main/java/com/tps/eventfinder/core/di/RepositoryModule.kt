package com.tps.eventfinder.core.di

import com.tps.eventfinder.features.event.data.datasources.remote.EventRemoteDataSource
import com.tps.eventfinder.features.event.data.repositories.EventRepositoryImpl
import com.tps.eventfinder.features.event.domain.repositories.EventRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
    fun provideEventRepository(api: EventRemoteDataSource): EventRepository = EventRepositoryImpl(api)
}