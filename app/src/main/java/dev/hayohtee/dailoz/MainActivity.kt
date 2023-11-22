package dev.hayohtee.dailoz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dagger.hilt.android.AndroidEntryPoint
import dev.hayohtee.dailoz.domain.repository.DestinationRepository
import dev.hayohtee.dailoz.ui.DailozApp
import dev.hayohtee.dailoz.ui.MainViewModel
import dev.hayohtee.dailoz.ui.theme.DailozTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var repository: DestinationRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.keepSplashScreenOn
            }
        }
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            DailozTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DailozApp(
                        destinationRepository = repository,
                        startDestination = viewModel.startDestination
                    )
                }
            }
        }
    }
}