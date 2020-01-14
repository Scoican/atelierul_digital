package com.example.gamecollector.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gamecollector.R
import kotlinx.android.synthetic.main.activity_game_page.*


class GamePageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_page)
        initForm()
    }

    private fun initForm() {
        println(intent.getStringExtra("Title"))
        game_page_title.text = intent.getStringExtra("Title")
        game_page_description_body.text = intent.getStringExtra("Description")
        game_page_rating.text = intent.getStringExtra("Rating")
        game_page_genre.text = intent.getStringExtra("Genre")
        game_page_year.text = intent.getStringExtra("Year")
    }
}
