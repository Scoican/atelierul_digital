package com.example. gamecollector.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gamecollector.R
import com.example.gamecollector.data.Game
import kotlinx.android.synthetic.main.activity_add_game.*

class AddGameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_game)
        initListeners()
    }

    private fun initListeners() {
        add_game_button.setOnClickListener{
            val game = Game (0,
                add_game_title.text.toString(),
                add_game_description.text.toString(),
                add_game_rating.text.toString().toFloat(),
                add_game_genre.text.toString(),
                add_game_year.text.toString().toInt()
            )
            val intent = Intent(this, MainMenuActivity::class.java)
            intent.putExtra("Title", game.title)
            intent.putExtra("Description", game.description)
            intent.putExtra("Rating", game.rating.toString())
            intent.putExtra("Genre", game.genre)
            intent.putExtra("Year", game.year.toString())
            startActivity(intent)
            finish()
        }
    }
}
