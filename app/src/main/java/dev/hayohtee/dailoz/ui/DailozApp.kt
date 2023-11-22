package dev.hayohtee.dailoz.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.hayohtee.dailoz.ui.screen.login.LoginDestination
import dev.hayohtee.dailoz.ui.screen.login.LoginScreen
import dev.hayohtee.dailoz.ui.screen.login.LoginViewModel
import dev.hayohtee.dailoz.ui.screen.onboarding.OnBoardingDestination
import dev.hayohtee.dailoz.ui.screen.onboarding.OnBoardingScreen
import dev.hayohtee.dailoz.ui.screen.signup.SignupDestination
import dev.hayohtee.dailoz.ui.screen.signup.SignupScreen
import dev.hayohtee.dailoz.ui.screen.signup.SignupViewModel

@Composable
fun DailozApp(
    startDestination: String,
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = OnBoardingDestination.route) {
            OnBoardingScreen(
                onLoginClick = { navController.navigate(route = LoginDestination.route) },
                onSignUpClick = { navController.navigate(route = SignupDestination.route) }
            )
        }

        composable(route = LoginDestination.route) {
            val viewModel: LoginViewModel = viewModel()
            val uiState by viewModel.uiState.collectAsState()

            LoginScreen(
                uiState = uiState,
                onEmailChange = viewModel::updateEmail,
                onPasswordChange = viewModel::updatePassword,
                onForgotPasswordClick = { /*TODO*/ },
                onLoginClick = { /*TODO*/ },
                onGoogleClick = { /*TODO*/ },
                onSignupClick = { navController.navigate(route = SignupDestination.route) }
            )
        }

        composable(route = SignupDestination.route) {
            val viewModel: SignupViewModel = viewModel()
            val uiState by viewModel.uiState.collectAsState()

            SignupScreen(
                uiState = uiState,
                onUsernameChange = viewModel::updateUsername,
                onEmailChange = viewModel::updateEmail,
                onPasswordChange = viewModel::updatePassword,
                onCreateClick = { /*TODO*/ },
                onGoogleClick = { /*TODO*/ },
                onSignInClick = { navController.navigate(route = LoginDestination.route) }
            )
        }
    }

}