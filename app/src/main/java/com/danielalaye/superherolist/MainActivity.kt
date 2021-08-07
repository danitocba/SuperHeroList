package com.danielalaye.superherolist

import RecyclerAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.danielalaye.superherolist.Models.Superhero

//Declaro el Recycler y el Adapter
lateinit var mRecyclerView : RecyclerView
val mAdapter : RecyclerAdapter = RecyclerAdapter()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerView()
    }

    //Configurar nuestro recyclerview con el adapter. El adapter será el encargado de tomar la lista de superheroes y mostrarla en el RecyclerView (vista)
    fun setUpRecyclerView(){
        mRecyclerView = findViewById<RecyclerView>(R.id.rvSuperheroList)
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter.RecyclerAdapter(getSuperheros(), this)
        mRecyclerView.adapter = mAdapter

    }

    //Funcion que devuelve una lista de Superheros.
    fun getSuperheros(): MutableList<Superhero>{
        var superheros:MutableList<Superhero> = ArrayList()
        superheros.add(Superhero("Spiderman", "Marvel", "Peter Parker", "https://cursokotlin.com/wp-content/uploads/2017/07/spiderman.jpg"))
        superheros.add(Superhero("Daredevil", "Marvel", "Matthew Michael Murdock", "https://cursokotlin.com/wp-content/uploads/2017/07/daredevil.jpg"))
        superheros.add(Superhero("Wolverine", "Marvel", "James Howlett", "https://cursokotlin.com/wp-content/uploads/2017/07/logan.jpeg"))
        superheros.add(Superhero("Batman", "DC", "Bruce Wayne", "https://cursokotlin.com/wp-content/uploads/2017/07/batman.jpg"))
        superheros.add(Superhero("Thor", "Marvel", "Thor Odinson", "https://cursokotlin.com/wp-content/uploads/2017/07/thor.jpg"))
        superheros.add(Superhero("Flash", "DC", "Jay Garrick", "https://cursokotlin.com/wp-content/uploads/2017/07/flash.png"))
        superheros.add(Superhero("Green Lantern", "DC", "Alan Scott", "https://cursokotlin.com/wp-content/uploads/2017/07/green-lantern.jpg"))
        superheros.add(Superhero("Wonder Woman", "DC", "Princess Diana", "https://cursokotlin.com/wp-content/uploads/2017/07/wonder_woman.jpg"))
        return  superheros
    }


}
