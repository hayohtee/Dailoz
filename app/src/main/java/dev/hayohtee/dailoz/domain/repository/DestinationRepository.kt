package dev.hayohtee.dailoz.domain.repository

import kotlinx.coroutines.flow.Flow

interface DestinationRepository {
    suspend fun saveStartDestination(startDestination: String)
    fun getStartDestination(): Flow<String?>
}