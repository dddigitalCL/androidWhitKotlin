package com.everis.appires

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.everis.appires.SharedApp.Companion.prefs


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLoggin = findViewById<Button>(R.id.btnIngresar)
        val btnSignIn = findViewById<Button>(R.id.btnRegistrar)
        checkUp()
        btnLoggin.setOnClickListener { showProfile() }
        btnSignIn.setOnClickListener { showRegistro()}

    }

    fun showRegistro(){
        //VISTA PARA QUE EL USUARIO SE REGISTRE
        startActivity(Intent(this, registro::class.java))
    }

    fun checkUp() {
        //Me valida que el usuario ya haya estado logeado. y solo haya cerrado la app
        if (prefs.name.toString().isNotEmpty() && prefs.password.toString().isNotEmpty() && prefs.forget){
            vistaApi()
        } /*else {
            prefs.prefs.edit().clear().apply()
        }*/
    }

    fun showProfile() {
        val usuario = findViewById<EditText>(R.id.etUser)
        val password = findViewById<EditText>(R.id.etPass)
        var check = findViewById<CheckBox>(R.id.chbForget)

        if (usuario.text.toString().isNotEmpty() &&
            password.text.toString().isNotEmpty()) {

            prefs.name = usuario.text.toString()
            prefs.password = password.text.toString()
            prefs.forget = check.isChecked


            if(prefs.name == prefs.datosUsuario && prefs.password == prefs.datosPassword){
                vistaApi()
            } else {
                dialogoInvalidPassword()
            }
         } else{
            dialogoError()
        }

    }


    fun dialogoInvalidPassword(){
        Toast.makeText(this, "Usted no se encuentra Registrado", Toast.LENGTH_SHORT).show()
    }

    fun dialogoError() {
        Toast.makeText(this, "Debe ingresar Usuario y Contraseña", Toast.LENGTH_SHORT).show()
    }

    fun vistaApi(){
        Toast.makeText(this, "INGRESADO", Toast.LENGTH_SHORT).show()
    }


}

