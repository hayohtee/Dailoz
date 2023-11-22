package dev.hayohtee.dailoz.data.local

import kotlinx.coroutines.flow.Flow

interface DestinationPreferences {
    suspend fun saveStartDestination(startDestination: String)
    fun getStartDestination(): Flow<String?>
}