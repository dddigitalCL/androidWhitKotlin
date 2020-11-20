package com.everis.appires


import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.everis.appires.SharedApp.Companion.prefs

class registro: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro)

        registrarUsuario()
        cancelarRegistro()
    }

    @SuppressLint("SetTextI18n")
    fun registrarUsuario() {
        val welcome = findViewById<TextView>(R.id.bienvenida)
        welcome.text = "Registro"

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etUsuario = findViewById<EditText>(R.id.etUsuario)
        val etCorreo = findViewById<EditText>(R.id.etCorreo)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val descripcion = findViewById<TextView>(R.id.tvDescripcion)

        etNombre.visibility = View.VISIBLE
        etUsuario.visibility = View.VISIBLE
        etCorreo.visibility = View.VISIBLE
        etPassword.visibility = View.VISIBLE
        descripcion.visibility = View.VISIBLE
        btnSave.visibility = View.VISIBLE

        btnSave.setOnClickListener {

            prefs.datosNombre = etNombre.text.toString()
            prefs.datosUsuario = etUsuario.text.toString()
            prefs.datosCorreo = etCorreo.text.toString()
            prefs.datosPassword = etPassword.text.toString()
            /*prefs.mutableProfile = mutableListOf(userProfile(
                        nombreProfile = etNombre.text.toString(),
                        usuarioProfile = etUsuario.text.toString(),
                        correoProfile = etCorreo.text.toString(),
                        passwordProfile = etPassword.text.toString()
                    ))*/


            if (prefs.datosUsuario!!.isNotEmpty() && prefs.datosNombre!!.isNotEmpty() &&
                prefs.datosPassword!!.isNotEmpty() && prefs.datosCorreo!!.isNotEmpty()
            ) {
                Toast.makeText(this, "Registro ha sido Exitoso", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Faltan datos", Toast.LENGTH_SHORT).show()
            }

        }

    }

    fun cancelarRegistro(){
        val btnLoggout = findViewById<Button>(R.id.btnCancel)
        btnLoggout.setOnClickListener{
            prefs.datosUsuario = ""
            prefs.datosPassword = ""
            onBackPressed()
            Toast.makeText(this, "El registro ha sido cancelado", Toast.LENGTH_SHORT).show()
        }
    }

}


