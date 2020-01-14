package com.example.gamecollector.data

import androidx.lifecycle.LiveData
import com.example.gamecollector.core.Result
import com.example.gamecollector.data.room.GameApi
import com.example.gamecollector.data.room.GameDao
import java.lang.Exception

class GameRepository(private val gameDao: GameDao) {

    val games = gameDao.getAll()

    suspend fun refresh():Result<Boolean>{
        try{
            val games= GameApi.service.find()
            for(game in games){
                gameDao.insert(game)
            }
            return Result.Success(true)
        }catch (e: Exception){
            return Result.Error(e)
        }
    }

    fun getById(gameId:Int): LiveData<Game> {
        return gameDao.getById(gameId)
    }

    fun addGame(game: Game){
        gameDao.insert(game)
    }

    fun getAll(): LiveData<List<Game>> {
        return games
    }
}