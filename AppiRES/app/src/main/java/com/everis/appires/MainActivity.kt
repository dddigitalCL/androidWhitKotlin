package com.everis.appires

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.everis.appires.SharedApp.Companion.prefs



class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnLoggin = findViewById<Button>(R.id.btnIngresar)
        val btnSignIn = findViewById<Button>(R.id.btnRegistrar)

        checkUp()
        btnLoggin.setOnClickListener { showProfile() }
        btnSignIn.setOnClickListener { showRegistro()}

    }

    private fun showRegistro(){
        //VISTA DE DATOS DE REGISTRO
        startActivity(Intent(this, registro::class.java))
    }

    private fun checkUp() {
        // VALIDA QUE EL USUARIO SE DESLOGEO O NO SELECCIONO LA CASILLA DE RECORDAR USUARIO
        if (prefs.name.toString().isNotEmpty() && prefs.password.toString().isNotEmpty() && prefs.forget){
            vistaApi()
        }
    }

    private fun showProfile() {
        // SE ENCARGA DE LA VISTA DE INICIO DE SESIÓN
        val usuario = findViewById<EditText>(R.id.etUser)
        val password = findViewById<EditText>(R.id.etPass)
        var check = findViewById<CheckBox>(R.id.chbForget)

        if (usuario.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()) {
            // VALIDA QUE LOS CAMPOS ESTEN LLENOS, Y SI LO ESTAN LOS GUARDAMOS PARA LA PERSISTENCIA DE DATOS
            prefs.name = usuario.text.toString()
            prefs.password = password.text.toString()
            prefs.forget = check.isChecked


            if(prefs.name == prefs.datosUsuario && prefs.password == prefs.datosPassword){
             // VALIDA QUE EL USUARIO ESTÉ REGISTRADO
                vistaApi()
            } else {
              // RETORNA PASSWORD INCORRECTA
                dialogoInvalidPassword()
            }
         } else{
            // RETORNA QUE DEBE COMPLETAR LOS CAMPOS
            dialogoError()
        }
    }

    fun dialogoInvalidPassword(){
        // ENVIA UN MENSAJE
        Toast.makeText(this, "Usted no se encuentra Registrado", Toast.LENGTH_SHORT).show()
    }

    fun dialogoError() {
        // ENVIA UN MENSAJE
        Toast.makeText(this, "Debe ingresar Usuario y Contraseña", Toast.LENGTH_SHORT).show()
    }

    fun vistaApi(){
        // ENVIA UN MENSAJE DE LOGIN EXITOSO Y ENVÍA A LA VISTA DEL API RES
        Toast.makeText(this, "INGRESADO", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, ApiDog::class.java))
       }


}



