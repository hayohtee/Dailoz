package dev.hayohtee.dailoz.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.hayohtee.dailoz.data.local.DestinationPreferences
import dev.hayohtee.dailoz.data.local.DestinationPreferencesImpl
import dev.hayohtee.dailoz.data.local.DestinationRepositoryImpl
import dev.hayohtee.dailoz.domain.repository.DestinationRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideDestinationPreferences(context: Context): DestinationPreferences {
        return DestinationPreferencesImpl(context)
    }

    @Provides
    @Singleton
    fun provideDestinationRepository(preferences: DestinationPreferences): DestinationRepository {
        return DestinationRepositoryImpl(preferences)
    }
}