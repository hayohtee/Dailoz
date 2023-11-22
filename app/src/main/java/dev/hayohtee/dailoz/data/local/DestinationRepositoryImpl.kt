package dev.hayohtee.dailoz.data.local

import dev.hayohtee.dailoz.domain.repository.DestinationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DestinationRepositoryImpl @Inject constructor(
    private val destinationPreferences: DestinationPreferences
) : DestinationRepository {
    override suspend fun saveStartDestination(startDestination: String) {
        destinationPreferences.saveStartDestination(startDestination)
    }

    override fun getStartDestination(): Flow<String?> {
        return destinationPreferences.getStartDestination()
    }
}