package dev.hayohtee.dailoz.ui.screen.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.hayohtee.dailoz.ui.navigateSingleTopTo
import dev.hayohtee.dailoz.ui.navigation.DailozNavigationBar
import dev.hayohtee.dailoz.ui.screen.activity.ActivityDestination
import dev.hayohtee.dailoz.ui.screen.activity.ActivityScreen
import dev.hayohtee.dailoz.ui.screen.home.HomeDestination
import dev.hayohtee.dailoz.ui.screen.home.HomeScreen
import dev.hayohtee.dailoz.ui.screen.profile.ProfileDestination
import dev.hayohtee.dailoz.ui.screen.profile.ProfileScreen
import dev.hayohtee.dailoz.ui.screen.task.TaskDestination
import dev.hayohtee.dailoz.ui.screen.task.TaskScreen

@Composable
fun MainScreen(
    onAddTaskClick: () -> Unit,
    modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Surface(color = MaterialTheme.colorScheme.background, modifier = modifier) {
        Box(modifier = Modifier.fillMaxSize()) {
            NavHost(
                navController = navController,
                startDestination = HomeDestination.route,
                modifier = Modifier.matchParentSize()
            ) {
                composable(route = HomeDestination.route) {
                    HomeScreen()
                }

                composable(route = TaskDestination.route) {
                    TaskScreen()
                }

                composable(route = ActivityDestination.route) {
                    ActivityScreen()
                }

                composable(route = ProfileDestination.route) {
                    ProfileScreen()
                }
            }
            DailozNavigationBar(
                currentDestination = currentDestination?.route ?: HomeDestination.route,
                onItemClick = { destination ->
                    navController.navigateSingleTopTo(destination)
                },
                onAddTaskClick = onAddTaskClick,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .navigationBarsPadding()
            )
        }
    }
}