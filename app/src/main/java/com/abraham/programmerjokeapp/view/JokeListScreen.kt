package com.abraham.programmerjokeapp.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.abraham.programmerjokeapp.controller.JokeViewModel
import com.abraham.programmerjokeapp.model.Joke

@Composable
fun JokeListScreen(viewModel:JokeViewModel= viewModel(), onJokeClick: (Joke) -> Unit) {
    val jokes by viewModel.jokes.collectAsState()
    LazyColumn {
        items(jokes){
            joke ->
            Text(
                text = joke.joke ?: joke.setup ?: "No Title",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onJokeClick(joke) }
                    .padding(16.dp)
            )
        }
    }
}


