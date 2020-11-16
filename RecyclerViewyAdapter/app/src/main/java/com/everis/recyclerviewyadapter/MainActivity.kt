package com.everis.recyclerviewyadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val actor:String = "Jason Statham"

    val actorMovie = listOf(
            ActorMovie( "Blitz", "Tom Brant","$actor", "2011", "https://www.clearplay.com/MovieBattle/images/tt1297919-1.jpg"),
            ActorMovie( "The Meg", "Jonas Taylor","$actor", "2018", "https://m.media-amazon.com/images/M/MV5BMTAxMGRmODYtM2NkYS00ZGRlLWE1MWItYjI1MzIwNjQwN2RiXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg"),
            ActorMovie( "Mechanic: Resurrection", "Arthur Bishop","$actor", "2016", "https://es.web.img3.acsta.net/pictures/16/08/01/17/32/024271.jpg"),
            ActorMovie( "Homefront", "Phil Broker","$actor", "2013", "https://upload.wikimedia.org/wikipedia/en/b/bf/Homefront_promotional_poster.jpg"),
            ActorMovie( "The Expendables  I", "Lee Christmas","$actor", "2010", "https://i.pinimg.com/474x/a6/0a/92/a60a92a1bd8082125935c5f8e6904a6e.jpg"),
            ActorMovie( "The Expendables II", "Lee Christmas","$actor", "2012", "https://www.denofgeek.com/wp-content/uploads/2012/08/exp2-main-1.jpg?fit=640%2C380"),
            ActorMovie( "The Expendables III", "Lee Christmas","$actor", "2014", "https://www.nme.com/wp-content/uploads/2016/09/2014Expendables3Lionsgate.png")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iniciarRecycler()
    }

    fun iniciarRecycler(){

        var rv = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.rvActor)

        rv.layoutManager = LinearLayoutManager(this)
        val adapter = ActorAdapter(actorMovie)
        rv.adapter = adapter

    }

}