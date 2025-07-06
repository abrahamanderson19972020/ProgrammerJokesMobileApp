package com.abraham.programmerjokeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abraham.programmerjokeapp.model.Joke
import com.abraham.programmerjokeapp.ui.theme.ProgrammerJokeAppTheme
import com.abraham.programmerjokeapp.view.JokeDetailScreen
import com.abraham.programmerjokeapp.view.JokeListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProgrammerJokeAppTheme {
                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "list_screen",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("list_screen") {
                            JokeListScreen(
                                onJokeClick = { selectedJoke ->
                                    navController.currentBackStackEntry?.savedStateHandle?.set("joke", selectedJoke)
                                    navController.navigate("detail_screen")
                                }
                            )
                        }
                        composable("detail_screen") {
                            val joke = navController.previousBackStackEntry
                                ?.savedStateHandle
                                ?.get<Joke>("joke")
                            if (joke != null) {
                                JokeDetailScreen(joke)
                            } else {
                                Text("Joke not found!")
                            }
                        }
                    }
                }
            }
        }
    }
}
