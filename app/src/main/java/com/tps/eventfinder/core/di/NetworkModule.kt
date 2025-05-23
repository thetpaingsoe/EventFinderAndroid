package com.tps.eventfinder.core.di

import com.tps.eventfinder.features.event.data.datasources.remote.EventRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideLoggingInterceptor(): Interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    fun provideOkHttpClient(logging: Interceptor): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(logging).build()

    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://app.ticketmaster.com/discovery/v2/")
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    @Provides
    fun provideApi(retrofit: Retrofit): EventRemoteDataSource = retrofit.create(EventRemoteDataSource::class.java)
}