package com.everis.sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.everis.sharedpreferences.SharedApp.Companion.prefs

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLoggin = findViewById<Button>(R.id.btnIngresar)
        checkUp()
        btnLoggin.setOnClickListener{ showProfile() }

    }

    fun showProfile() {
        val usuario = findViewById<EditText>(R.id.etUser)
        val password = findViewById<EditText>(R.id.etPass)
        var check = findViewById<CheckBox>(R.id.chbForget)

        if (usuario.text.toString().isNotEmpty() &&
            password.text.toString().isNotEmpty() ){

                prefs.name = usuario.text.toString()
                prefs.password = password.text.toString()
                prefs.forget = check.isChecked
                secondView()
        } else {
            dialogoError()
        }

    }
    fun dialogoError(){
        Toast.makeText(this, "Debe ingresar Usuario y Contraseña", Toast.LENGTH_SHORT).show()
    }

    fun secondView(){
        startActivity(Intent(this, ingreso::class.java))
    }

    fun checkUp(){

        if(prefs.name.toString().isNotEmpty() && prefs.password.toString().isNotEmpty() && prefs.forget == true){
            secondView()
        }else{
            prefs.prefs.edit().clear().apply()
            showProfile()
        }
    }


}