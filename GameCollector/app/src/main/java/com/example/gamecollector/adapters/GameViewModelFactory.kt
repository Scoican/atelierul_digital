package com.example.gamecollector.adapters

import androidx.lifecycle.ViewModelProvider

class GameViewModelFactory : ViewModelProvider.NewInstanceFactory() {


    internal var t: GameViewModel? = null

    fun create(modelClass: Class<GameViewModel>): GameViewModel? {
        return t
    }
}