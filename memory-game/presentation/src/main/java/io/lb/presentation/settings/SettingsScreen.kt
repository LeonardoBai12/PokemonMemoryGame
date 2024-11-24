package io.lb.presentation.settings

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import io.lb.common.data.model.PokemonCard
import io.lb.presentation.game.model.GameCard
import io.lb.presentation.ui.components.IntSelector
import io.lb.presentation.ui.components.MemoryGameBackButton
import io.lb.presentation.ui.components.MemoryGameCard
import io.lb.presentation.ui.components.MemoryGameStopButton

@ExperimentalFoundationApi
@ExperimentalMaterial3Api
@Composable
fun SettingsScreen(
    navController: NavController,
    cardsPerLine: Int,
    cardsPerColumn: Int,
    isDarkMode: Boolean,
    onChangeDarkMode: (Boolean) -> Unit,
    onChangeCardsPerLine: (Int) -> Unit,
    onChangeCardsPerColumn: (Int) -> Unit
) {
    val selectedCardsPerLine = remember {
        mutableIntStateOf(cardsPerLine)
    }
    val selectedCardsPerColumn = remember {
        mutableIntStateOf(cardsPerColumn)
    }
    val darkMode = remember {
        mutableStateOf(isDarkMode)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                MemoryGameBackButton(
                    modifier = Modifier.padding(
                        top = 16.dp,
                        start = 16.dp
                    ),
                ) {
                    navController.navigateUp()
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    "Dark mode",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Spacer(modifier = Modifier.size(12.dp))

                Switch(
                    checked = darkMode.value,
                    onCheckedChange = {
                        darkMode.value = it
                        onChangeDarkMode(it)
                    }
                )
            }

            Text(
                "Game screen layout",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.size(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "Cards per line",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    IntSelector(
                        intState = selectedCardsPerLine,
                        minValue = 3,
                        maxValue = 6,
                        spaceBetween = 12,
                        textSize = 48,
                        isDarkMode = darkMode.value,
                        onChangeAmount = {
                            onChangeCardsPerLine(it)
                        }
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "Cards per column",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    IntSelector(
                        intState = selectedCardsPerColumn,
                        minValue = 5,
                        maxValue = 9,
                        spaceBetween = 12,
                        textSize = 48,
                        isDarkMode = darkMode.value,
                        onChangeAmount = {
                            onChangeCardsPerColumn(it)
                        }
                    )
                }
            }

            Text(
                "Preview",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.size(12.dp))

            LazyVerticalGrid(
                modifier = Modifier
                    .padding(horizontal = 12.dp),
                columns = GridCells.Fixed(selectedCardsPerLine.intValue),
                userScrollEnabled = true,
            ) {
                items(16) {
                    MemoryGameCard(
                        GameCard(
                            pokemonCard = PokemonCard(
                                id = "",
                                pokemonId = 0,
                                name = "",
                                imageData = ByteArray(0),
                                imageUrl = ""
                            ),
                            isFlipped = false,
                            isMatched = false
                        ),
                        cardsPerLine = selectedCardsPerLine.intValue,
                        cardsPerColumn = selectedCardsPerColumn.intValue
                    ) {

                    }
                }
            }
        }
    }
}
