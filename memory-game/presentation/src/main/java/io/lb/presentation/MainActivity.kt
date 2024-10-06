package io.lb.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import io.lb.presentation.game.GameEvent
import io.lb.presentation.game.GameScreen
import io.lb.presentation.game.GameViewModel
import io.lb.presentation.menu.MenuScreen
import io.lb.presentation.ui.navigation.MemoryGameScreens
import io.lb.presentation.ui.theme.PokemonMemoryChallengeTheme

@ExperimentalMaterial3Api
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonMemoryChallengeTheme {
                val navController = rememberNavController()
                val gameViewModel = hiltViewModel<GameViewModel>()
                val gameState = gameViewModel.state.collectAsState().value

                NavHost(
                    navController = navController,
                    startDestination = MemoryGameScreens.Menu.name
                ) {
                    composable(MemoryGameScreens.Menu.name) {
                        MenuScreen(
                            navController = navController,
                            onClickQuit = {
                                finish()
                            }
                        )
                    }
                    composable(
                        route = MemoryGameScreens.Game.name + "/{amount}",
                        arguments = listOf(
                            navArgument(name = "amount") {
                                type = NavType.IntType
                            }
                        )
                    ) { backStackEntry ->
                        val amount = backStackEntry.arguments?.getInt("amount") ?: 5
                        gameViewModel.onEvent(GameEvent.GetCards(amount))
                        GameScreen(
                            navController = navController,
                            state = gameState
                        )
                    }
                }
            }
        }
    }
}
