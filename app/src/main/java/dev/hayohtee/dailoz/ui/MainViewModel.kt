package dev.hayohtee.dailoz.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.hayohtee.dailoz.domain.repository.DestinationRepository
import dev.hayohtee.dailoz.ui.screen.onboarding.OnBoardingDestination
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    destinationRepository: DestinationRepository
) : ViewModel() {
    var startDestination by mutableStateOf(OnBoardingDestination.route)
        private set

    var keepSplashScreenOn by mutableStateOf(true)
        private set

    init {
        destinationRepository.getStartDestination().onEach {
            startDestination = it ?: OnBoardingDestination.route
            delay(300)
            keepSplashScreenOn = false
        }.launchIn(viewModelScope)
    }
}