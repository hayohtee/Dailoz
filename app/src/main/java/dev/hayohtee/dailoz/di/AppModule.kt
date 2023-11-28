package dev.hayohtee.dailoz.di

import android.app.Application
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
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
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun provideFireStore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @Provides
    @Singleton
    fun provideDestinationPreferences(application: Application): DestinationPreferences {
        return DestinationPreferencesImpl(application)
    }

    @Provides
    @Singleton
    fun provideDestinationRepository(preferences: DestinationPreferences): DestinationRepository {
        return DestinationRepositoryImpl(preferences)
    }
}