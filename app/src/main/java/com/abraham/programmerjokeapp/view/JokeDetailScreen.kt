package com.abraham.programmerjokeapp.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.abraham.programmerjokeapp.model.Joke
import com.abraham.programmerjokeapp.model.JokeType

@Composable
fun JokeDetailScreen(
    joke:Joke,
    onBack:() -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Category: ${joke.category}",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        if(joke.type == JokeType.single){
            Text(
                text = joke.joke ?: "No joke text",
                style = MaterialTheme.typography.bodyLarge
            )
        } else if (joke.type == JokeType.twopart){
            Text(
                text = joke.setup ?: "No Setup",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = joke.delivery ?: "No Delivery",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}