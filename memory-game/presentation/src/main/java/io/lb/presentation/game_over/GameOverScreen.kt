package io.lb.presentation.game_over

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import io.lb.common.data.model.Score
import io.lb.presentation.R
import io.lb.presentation.ui.components.MemoryGameWhiteButton
import io.lb.presentation.ui.navigation.MemoryGameScreens
import io.lb.presentation.util.toDateFormat

@Composable
fun GameOverScreen(
    navController: NavController,
    score: Int
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.White
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.pokemon_game_logo),
                contentDescription = "Pokemon Game Logo",
            )
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "You won!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(48.dp))

            Text(
                text = "Score: $score",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                MemoryGameWhiteButton(
                    text = "BACK",
                    onClick = {
                        navController.navigate(MemoryGameScreens.Menu.name) {
                            popUpTo(MemoryGameScreens.Menu.name) {
                                inclusive = true
                            }
                        }
                    }
                )
                Spacer(modifier = Modifier.height(24.dp))
                Image(
                    modifier = Modifier.size(48.dp),
                    painter = painterResource(id = R.drawable.pokeball),
                    contentDescription = "PokeBall",
                )
            }
        }
    }
}