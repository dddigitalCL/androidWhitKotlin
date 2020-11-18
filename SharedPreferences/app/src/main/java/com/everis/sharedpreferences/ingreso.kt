package com.everis.sharedpreferences

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.everis.sharedpreferences.R.id.*
import com.everis.sharedpreferences.SharedApp.Companion.prefs

class ingreso: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ingreso)

        mostrarUsuario()
        loggout()
}

    @SuppressLint("SetTextI18n")
    fun mostrarUsuario(){
        val welcome = findViewById<TextView>(bienvenida)
        welcome.text = "Bienvenido ${prefs.name}"

        val etNombre = findViewById<EditText>(etNombre)
        val etApellido = findViewById<EditText>(etApellido)
        val etEdad = findViewById<EditText>(etEdad)
        val etEstadoCivil = findViewById<EditText>(etEstadoCivil)

        val descripcion = findViewById<TextView>(tvDescripcion)
        val nombre = findViewById<TextView>(tvMostrarNombre)
        val apellido = findViewById<TextView>(tvMostrarApellido)
        val edad = findViewById<TextView>(tvMostrarEdad)
        val eCivil = findViewById<TextView>(tvMostrarEstadoCivil)

        val btnSave = findViewById<Button>(btnSave)
        if(prefs.datosNombre.isNullOrEmpty() && prefs.datosApellido.isNullOrEmpty() && prefs.datosEdad.isNullOrEmpty() && prefs.datosCivil.isNullOrEmpty()){

            etNombre.visibility = View.VISIBLE
            etApellido.visibility = View.VISIBLE
            etEdad.visibility = View.VISIBLE
            etEstadoCivil.visibility = View.VISIBLE
            descripcion.visibility = View.VISIBLE

            nombre.visibility = View.GONE
            apellido.visibility = View.GONE
            edad.visibility = View.GONE
            eCivil.visibility = View.GONE

            btnSave.visibility = View.VISIBLE

            /*dataSave()*/
            val btnSave = findViewById<Button>(R.id.btnSave)
            val put = prefs.prefs.edit()
            btnSave.setOnClickListener{

                prefs.datosNombre = etNombre.text.toString()
                prefs.datosApellido = etApellido.text.toString()
                prefs.datosEdad = etEdad.text.toString()
                prefs.datosCivil = etEstadoCivil.text.toString()

                /*

                PARA QUE NO HAGA CAMBIO DE PANTALLA

                nombre.text = "Nombre: ${prefs.datosNombre}"
                apellido.text ="Apellido: ${prefs.datosApellido}"
                edad.text ="Edad: ${prefs.datosEdad}"
                eCivil.text ="Estado: ${prefs.datosCivil}"

                nombre.visibility = View.VISIBLE
                apellido.visibility = View.VISIBLE
                edad.visibility = View.VISIBLE
                eCivil.visibility = View.VISIBLE

                descripcion.visibility = View.GONE
                etNombre.visibility = View.GONE
                etApellido.visibility = View.GONE
                etEdad.visibility = View.GONE
                etEstadoCivil.visibility = View.GONE
                btnSave.visibility = View.INVISIBLE

                */

                Toast.makeText(this, "Información guardada", Toast.LENGTH_SHORT).show()
            }


        }else{

            nombre.text = "Nombre: ${prefs.datosNombre}"
            apellido.text ="Apellido: ${prefs.datosApellido}"
            edad.text ="Edad: ${prefs.datosEdad}"
            eCivil.text ="Estado: ${prefs.datosCivil}"

            nombre.visibility = View.VISIBLE
            apellido.visibility = View.VISIBLE
            edad.visibility = View.VISIBLE
            eCivil.visibility = View.VISIBLE

            descripcion.visibility = View.GONE
            etNombre.visibility = View.GONE
            etApellido.visibility = View.GONE
            etEdad.visibility = View.GONE
            etEstadoCivil.visibility = View.GONE

            btnSave.visibility = View.INVISIBLE
        }
    }

    fun loggout(){
        val btnLoggout = findViewById<Button>(R.id.btnLoggout)
        btnLoggout.setOnClickListener{
            prefs.prefs.edit().clear().apply()
            onBackPressed()
            Toast.makeText(this, "Ha deslogeado exitasamente", Toast.LENGTH_SHORT).show()
        }
    }

   /* fun dataSave(){
        val btnSave = findViewById<Button>(R.id.btnSave)
        val put = prefs.prefs.edit()
       btnSave.setOnClickListener{

           prefs.datosNombre = etNombre.text.toString()
           prefs.datosApellido = etApellido.text.toString()
           prefs.datosEdad = etEdad.text.toString()
           prefs.datosCivil = etEstadoCivil.text.toString()

           *//*put.putString(prefs.SHAREDNOMBRE, etNombre.toString()).apply()
           put.putString(prefs.SHAREDAPELLIDO, etApellido.toString()).apply()
           put.putString(prefs.SHAREDEDAD, etEdad.toString()).apply()
           put.putString(prefs.SHAREDCIVIL, etEstadoCivil.toString()).apply()*//*

           Toast.makeText(this, "se ha guardado con éxito", Toast.LENGTH_SHORT).show()
       }
    }*/


}