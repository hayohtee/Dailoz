package dev.hayohtee.dailoz.data.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import dev.hayohtee.dailoz.dataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DestinationPreferencesImpl @Inject constructor(
    private val context: Context
) : DestinationPreferences {
    override suspend fun saveStartDestination(startDestination: String) {
        context.dataStore.edit { preferences ->
            preferences[START_DESTINATION_PREFERENCE_KEY] = startDestination
        }
    }

    override fun getStartDestination(): Flow<String?> {
        return context.dataStore.data.map { preferences ->
            preferences[START_DESTINATION_PREFERENCE_KEY]
        }
    }

    companion object {
        val START_DESTINATION_PREFERENCE_KEY = stringPreferencesKey("start_destination")
    }
}