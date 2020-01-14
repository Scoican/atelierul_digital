package com.example.gamecollector.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.gamecollector.data.Game
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.room.migration.Migration
import android.icu.lang.UCharacter.GraphemeClusterBreak.V

@Database(entities = [Game::class], version = 2, exportSchema = false)
abstract class GameDatabase : RoomDatabase() {

    abstract fun itemDao(): GameDao

    companion object {
        @Volatile
        private var INSTANCE: GameDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): GameDatabase {
            val inst = INSTANCE
            if (inst != null) {
                return inst
            }
            val instance =
                Room.databaseBuilder(
                    context.applicationContext,
                    GameDatabase::class.java,
                    "game_db"
                )
                    .addCallback(WordDatabaseCallback(scope))
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            INSTANCE = instance
            return instance
        }

        private class WordDatabaseCallback(private val scope: CoroutineScope) :
            RoomDatabase.Callback() {

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                       populateDatabase(database.itemDao())
                    }
                }
            }
        }

        private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("DROP TABLE games")
            }
        }

        fun populateDatabase(gameDao: GameDao) {
            gameDao.deleteAll()
            var game = Game(
                1,
                "The Witcher 3: Wild Hunt",
                "The Witcher: Wild Hunt is a story-driven, next-generation open world role-playing game set in a visually stunning fantasy universe full of meaningful choices and impactful consequences. In The Witcher you play as the professional monster hunter, Geralt of Rivia, tasked with finding a child of prophecy in a vast open world rich with merchant cities, viking pirate islands, dangerous mountain passes, and forgotten caverns to explore.",
                9.7F,
                "RPG",
                2015
            )
            gameDao.insert(game)
            game = Game(
                2,
                "The Witcher",
                "Being based on a novel series by Andrzej Sapkowski – a bestselling Polish author – gives the game’s universe and characters credibility, authority and exceptional cohesiveness. In this harsh fantasy world abstract, absolute and unconditional ideas such as “Good” and “Evil” written in upper case letters do not exist. Instead, however, while moral good exists , the protagonist will often only have a choice between two evils, deciding on the path which he regards as the lesser evil of the two. The game also features an innovative, time delayed decision-consequence system, prodding players to make their decisions seriously and with thought.",
                9F,
                "RPG",
                2007
            )
            gameDao.insert(game)
            game = Game(
                3,
                "The Binding of Isaac",
                "The Binding of Isaac is a randomly generated action RPG shooter with heavy Rogue-like elements. Following Isaac on his journey players will find bizarre treasures that change Isaac’s form giving him super human abilities and enabling him to fight off droves of mysterious creatures, discover secrets and fight his way to safety. \n \nKey features: \n \nRandomly generated dungeons, items enemies and bosses, you never play the same game twice. \nOver 100 unique items that not only give you powers but visually change your character. \n50+ enemy types each with the ability to become \"special\" making them extra deadly but they also drop better loot. \nOver 20 bosses. \n4 full chapters spanning 8 levels \n3+ unlockable classes \nMultiple endings \nTons of unlockable items, enemies, bosses and more.",
                9F,
                "Indie",
                2011
            )
            gameDao.insert(game)
            game = Game(
                4,
                "The Binding of Isaac: Rebirth",
                "The Binding of Isaac: Rebirth is a top down, procedurally-generated rougelike game, remade based on the original game The Binding of Isaac. You play as Isaac, a little boy who is chased to the basement by his mother who intends to kill Isaac for her savior. You explore different levels, collect items and try to defeat your mother.. and whatever other evil awaits you. If you die, you restart with none of your items you collected, and you must explore the basement and beyond again.",
                9F,
                "Indie",
                2014
            )
            gameDao.insert(game)
            game = Game(
                5,
                "League of Legends",
                "League of Legends is a fast-paced, competitive online game that blends the speed and intensity of an RTS with RPG elements. Two teams of powerful champions, each with a unique design and playstyle, battle head-to-head across multiple battlefields and game modes. With an ever-expanding roster of champions, frequent updates and a thriving tournament scene, League of Legends offers endless replayability for players of every skill level.",
                10F,
                "MOBA",
                2009
            )
            gameDao.insert(game)
        }
    }

}