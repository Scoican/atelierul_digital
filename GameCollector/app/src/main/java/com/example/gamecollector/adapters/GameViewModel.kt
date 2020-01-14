package com.example.gamecollector.adapters

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.gamecollector.core.TAG
import com.example.gamecollector.core.Result
import com.example.gamecollector.data.Game
import com.example.gamecollector.data.GameRepository
import com.example.gamecollector.data.room.GameDatabase
import kotlinx.coroutines.launch

class GameViewModel(application: Application) : AndroidViewModel(application) {

    val games: LiveData<List<Game>>

    val gameRepository : GameRepository

    init {
        val gameDao = GameDatabase.getDatabase(application, viewModelScope).itemDao()
        gameRepository= GameRepository(gameDao)
        games = gameRepository.games
    }

    fun refresh() {
        viewModelScope.launch {
            when (val result = gameRepository.refresh()) {
                is Result.Success -> {
                    Log.d(TAG, "refresh succeeded")
                }
                is Result.Error -> {
                    Log.w(TAG, "refresh failed", result.exception)
                }
            }
        }
    }

}