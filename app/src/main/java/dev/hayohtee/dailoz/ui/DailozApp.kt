package dev.hayohtee.dailoz.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import dev.hayohtee.dailoz.domain.repository.DestinationRepository
import dev.hayohtee.dailoz.ui.screen.addtask.AddTaskDestination
import dev.hayohtee.dailoz.ui.screen.addtask.AddTaskScreen
import dev.hayohtee.dailoz.ui.screen.home.HomeDestination
import dev.hayohtee.dailoz.ui.screen.login.LoginDestination
import dev.hayohtee.dailoz.ui.screen.login.LoginScreen
import dev.hayohtee.dailoz.ui.screen.login.LoginViewModel
import dev.hayohtee.dailoz.ui.screen.main.MainScreen
import dev.hayohtee.dailoz.ui.screen.main.MainScreenDestination
import dev.hayohtee.dailoz.ui.screen.onboarding.OnBoardingDestination
import dev.hayohtee.dailoz.ui.screen.onboarding.OnBoardingScreen
import dev.hayohtee.dailoz.ui.screen.signup.SignupDestination
import dev.hayohtee.dailoz.ui.screen.signup.SignupScreen
import dev.hayohtee.dailoz.ui.screen.signup.SignupViewModel
import kotlinx.coroutines.launch

@Composable
fun DailozApp(
    startDestination: String,
    destinationRepository: DestinationRepository,
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = OnBoardingDestination.route) {
            val coroutineScope = rememberCoroutineScope()
            OnBoardingScreen(
                onLoginClick = {
                    coroutineScope.launch {
                        destinationRepository.saveStartDestination(LoginDestination.route)
                    }
                },
                onSignUpClick = {
                    coroutineScope.launch {
                        destinationRepository.saveStartDestination(SignupDestination.route)
                    }
                }
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
                onSignupClick = {
                    navController.navigateSingleTopTo(route = SignupDestination.route)
                }
            )
        }

        navigation(route = MainScreenDestination.route, startDestination = HomeDestination.route) {
            composable(route = HomeDestination.route) {
                MainScreen(
                    onAddTaskClick = {
                        navController.navigate(route = AddTaskDestination.route)
                    }
                )
            }
        }

        composable(route = AddTaskDestination.route) {
            AddTaskScreen()
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
                onSignInClick = {
                    navController.navigateSingleTopTo(route = LoginDestination.route)
                }
            )
        }
    }

}

fun NavHostController.navigateSingleTopTo(route: String) {
    this.navigate(route = route) {
        popUpTo(this@navigateSingleTopTo.graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}