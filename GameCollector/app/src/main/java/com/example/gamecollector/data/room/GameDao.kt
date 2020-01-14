package com.example.gamecollector.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.gamecollector.data.Game

@Dao
interface GameDao{
    @Query("SELECT * from games ORDER BY title ASC")
    fun getAll():LiveData<List<Game>>

    @Query("SELECT * FROM games WHERE _id=:id ")
    fun getById(id: Int): LiveData<Game>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(habit: Game)

    @Query("DELETE FROM games")
    fun deleteAll()
}