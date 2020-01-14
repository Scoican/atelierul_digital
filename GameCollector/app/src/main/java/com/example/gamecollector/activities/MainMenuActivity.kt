package com.example.gamecollector.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamecollector.R
import com.example.gamecollector.adapters.GameViewModel
import com.example.gamecollector.adapters.OnItemClickListener
import com.example.gamecollector.adapters.RecyclerViewAdapter
import com.example.gamecollector.data.Game
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.activity_main_menu.*
import lecho.lib.hellocharts.model.PieChartData
import lecho.lib.hellocharts.model.SliceValue
import lecho.lib.hellocharts.view.PieChartView
import java.util.*


@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS",
    "NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS"
)
class MainMenuActivity : AppCompatActivity(), OnItemClickListener {

    override fun onItemClicked(game: Game) {
        val intent = Intent(this, GamePageActivity::class.java)
        intent.putExtra("Title", game.title)
        intent.putExtra("Description", game.description)
        intent.putExtra("Rating", game.rating.toString())
        intent.putExtra("Genre", game.genre)
        intent.putExtra("Year", game.year.toString())
        startActivity(intent)
    }

    private lateinit var gameViewModel: GameViewModel
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private var doubleBackToExitPressedOnce = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        initRecyclerView()
        getIntents()
        initFloatingActionButton()
    }

    private fun getIntents() {
        val title = intent.getStringExtra("Title")
        if(title!=null){
            val description = intent.getStringExtra("Description")
            val rating = intent.getStringExtra("Rating").toString().toFloat()
            val genre = intent.getStringExtra("Genre")
            val year = intent.getStringExtra("Year").toString().toInt()

            val game = Game(0,title,description,rating,genre,year)
            gameViewModel.gameRepository.addGame(game)
        }
    }

    private fun initFloatingActionButton() {
        fab.setOnClickListener {
            val intent = Intent(this, AddGameActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun initRecyclerView() {
        recycler_view.isNestedScrollingEnabled = false

        val layoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = layoutManager

        recyclerViewAdapter = RecyclerViewAdapter(this, this)
        recycler_view.adapter = recyclerViewAdapter

        gameViewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        gameViewModel.games.observe(this, Observer { items ->
            Log.v("app", "update items")
            recyclerViewAdapter.gameList = items
            initPieChart(items)
        })
        gameViewModel.refresh()
    }

    private fun initPieChart(items: List<Game>) {
        val pieData: MutableList<PieEntry> = mutableListOf()

        val data = getPieChartData(items)

        val rnd = Random()

        data.forEach {
            pieData.add(PieEntry(it.value.toFloat(),it.key))
        }
        val pieChartView: PieChart = findViewById(R.id.chart)

        val pieDataSet = PieDataSet(pieData,"Genres")
        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS)
        val pieChart = PieData(pieDataSet)
        pieChartView.data = pieChart
        pieChartView.holeRadius = 20f
        pieChartView.transparentCircleRadius = 20f
        pieChartView.setDescription("Genres")
        pieChartView.setDescriptionColor(2)
    }

    private fun getPieChartData(gameList: List<Game>): MutableMap<String, Int> {
        val numbersMap = mutableMapOf<String,Int>()
        gameList.forEach {
            if(!numbersMap.containsKey(it.genre)){
                numbersMap[it.genre] = 1
            }else {
                numbersMap[it.genre] = numbersMap.getValue(it.genre)+1
            }
        }
        return numbersMap
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }
        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Please click BACK again to exit activity", Toast.LENGTH_SHORT).show()

        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }
}
