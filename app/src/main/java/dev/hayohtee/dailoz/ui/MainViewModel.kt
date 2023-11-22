package dev.hayohtee.dailoz.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.hayohtee.dailoz.domain.repository.DestinationRepository
import dev.hayohtee.dailoz.ui.screen.onboarding.OnBoardingDestination
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val destinationRepository: DestinationRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            destinationRepository.getStartDestination().collectLatest { destination ->
                _uiState.value = _uiState.value.copy(
                    startDestination = destination ?: OnBoardingDestination.route,
                    keepSplashScreenOn = false
                )
            }
        }
    }
}