package com.example.gamecollector.data
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName= "Games")
data class Game(
    @PrimaryKey @ColumnInfo(name="_id") val _id:Int,
    @ColumnInfo(name="title") var title:String,
    @ColumnInfo(name="description") var description:String,
    @ColumnInfo(name="rating") var rating:Float,
    @ColumnInfo(name="genre") var genre:String,
    @ColumnInfo(name="year") var year:Int
)
{
    override fun toString(): String {
        return "Habit(_id='$_id', title='$title', description='$description', rating='$rating', genre='$genre', year='$year')"
    }
}