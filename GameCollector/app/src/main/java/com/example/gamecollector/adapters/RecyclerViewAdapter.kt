package com.example.gamecollector.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gamecollector.R
import com.example.gamecollector.activities.GamePageActivity
import com.example.gamecollector.data.Game
import kotlinx.android.synthetic.main.item_game.view.*

class RecyclerViewAdapter(var context: Context,val itemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<RecyclerViewAdapter.RecycleViewHolder>() {

    var gameList = emptyList<Game>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecycleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_game, parent, false)
        return RecycleViewHolder(view)
    }

    override fun getItemCount() = gameList.size

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        holder.container.animation =
            AnimationUtils.loadAnimation(context, R.anim.game_card_animation)
        val item = gameList[position]
        holder.gameTitle.text = item.title
        holder.gameRating.text = item.rating.toString()
        holder.bind(gameList[position],itemClickListener)
    }

    inner class RecycleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val gameTitle: TextView = view.item_game_title
        val gameRating: TextView = view.item_game_rating
        val gameGenre: TextView = view.item_game_platform
        val container: LinearLayout = view.game_item

        fun bind(game: Game,clickListener: OnItemClickListener)
        {
            gameTitle.text = game.title
            gameRating.text = game.rating.toString()
            gameGenre.text = game.genre

            itemView.setOnClickListener {
                clickListener.onItemClicked(game)

            }
        }
    }

    private var onItemClick: View.OnClickListener

    init {
        onItemClick = View.OnClickListener {
            val item = it.tag as? Game
            val intent = Intent(context, GamePageActivity::class.java)
            intent.putExtra("Title", item?.title)
            intent.putExtra("Description", item?.description)
            intent.putExtra("Rating", item?.rating)
            intent.putExtra("Genre", item?.genre)
            intent.putExtra("Year", item?.year)
            it.context.startActivity(intent)
        }

    }
}


interface OnItemClickListener{
    fun onItemClicked(game: Game)
}