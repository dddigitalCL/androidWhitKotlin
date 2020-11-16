package com.everis.ejercicio1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val btnVolver = findViewById<Button>(R.id.button) as Button
        btnVolver.setOnClickListener{ onBackPressed()}
        obtenerResultados()
        obtenerMostrarNombre()

    }


    fun obtenerMostrarNombre(){
        val bundle = intent.extras
        val nombreRecuperado = bundle!!.get("nombreIngresado")
        val welcome = findViewById<TextView>(R.id.bienvenida)
        welcome.text = "Bienvenido $nombreRecuperado"

            }

    fun obtenerResultados(){
        var bundle = intent.extras
        var dig1:Float = bundle!!.getFloat("numero1")
        var dig2:Float = bundle!!.getFloat("numero2")


        var suma = findViewById<TextView>(R.id.suma)
        var resta = findViewById<TextView>(R.id.resta)
        var mult = findViewById<TextView>(R.id.mult)

        var resSuma = dig1 + dig2
        var resResta = dig1 - dig2
        var resMult = dig1*dig2

        suma.text = "$resSuma"
        resta.text = "$resResta"
        mult.text = "$resMult"
    }



}