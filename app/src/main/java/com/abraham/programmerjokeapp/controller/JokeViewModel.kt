package com.abraham.programmerjokeapp.controller

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abraham.programmerjokeapp.model.Joke
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import java.net.URL

class JokeViewModel:ViewModel() {
    private val _jokes = MutableStateFlow<List<Joke>>(emptyList())
    val jokes:StateFlow<List<Joke>> = _jokes
   init {
       loadJokes()
   }
    fun loadJokes(){
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    URL("https://raw.githubusercontent.com/atilsamancioglu/ProgrammingJokesJSON/main/jokes.json").readText()
                }
                val jokeList = Json.decodeFromString<List<Joke>>(response)
                _jokes.value = jokeList
            }catch (ex:Exception){
                ex.printStackTrace()
            }
        }
    }
}