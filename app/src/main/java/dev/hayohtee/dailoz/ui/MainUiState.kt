package dev.hayohtee.dailoz.ui

import dev.hayohtee.dailoz.ui.navigation.DailozDestination
import dev.hayohtee.dailoz.ui.screen.onboarding.OnBoardingDestination

data class MainUiState(
    val keepSplashScreenOn: Boolean = true,
    val startDestination: String = OnBoardingDestination.route
)
