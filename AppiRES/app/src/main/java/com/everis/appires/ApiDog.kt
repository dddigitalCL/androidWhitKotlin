package com.everis.appires

import APIService
import DogsAdapter
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.apidog.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

lateinit var imagesPuppies:List<String>
lateinit var dogsAdapter:DogsAdapter

class ApiDog : AppCompatActivity(), androidx.appcompat.widget.SearchView.OnQueryTextListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.apidog)
        searchBreed.setOnQueryTextListener(this)
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun searchByName(query: String) {
        doAsync {
            val call =
                getRetrofit().create(APIService::class.java).getCharacterByName("$query/images")
                    .execute()
            val puppies = call.body() as DogsResponse
            uiThread {
                if (puppies.status == "success") {
                    initCharacter(puppies)
                } else {
                    showErrorDialog()
                }
                hideKeyboard()
            }
        }
    }

    private fun initCharacter(puppies: DogsResponse) {
        if (puppies.status == "success") {
            imagesPuppies = puppies.images
        }
        dogsAdapter = DogsAdapter(imagesPuppies)
        rvDogs.setHasFixedSize(true)
        rvDogs.layoutManager = LinearLayoutManager(this)
        rvDogs.adapter = dogsAdapter
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        searchByName(query.toLowerCase())
        return true
    }

    private fun showErrorDialog() {
        alert("Ha ocurrido un error, inténtelo de nuevo.") {
            yesButton { }
        }.show()
    }

    private fun hideKeyboard() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(viewRoot.windowToken, 0)
    }
}