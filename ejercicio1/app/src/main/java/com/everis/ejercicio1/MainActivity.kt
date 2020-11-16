package com.everis.ejercicio1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ingreso = findViewById<Button>(R.id.ingresar) as Button
        ingreso.setOnClickListener { validarIngreso() }
    }

    fun validarIngreso() {
        var nombre = findViewById<TextView>(R.id.nombre)
        var nume1 = findViewById<EditText>(R.id.primerNumero)
        var nume2 = findViewById<EditText>(R.id.segundoNumero)

        if (nombre.text.isNotEmpty() && nume1.text.isNotEmpty() && nume2.text.isNotEmpty()) {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("nombreIngresado", nombre.text)
            intent.putExtra("numero1", nume1.text.toString().toFloat())
            intent.putExtra("numero2", nume2.text.toString().toFloat())
                startActivity(intent)
    }else{
            dialogoError()
        }
    }

    fun dialogoError(){
        Toast.makeText(this, "Debe ingresar todos los datos", Toast.LENGTH_SHORT)
    }
}