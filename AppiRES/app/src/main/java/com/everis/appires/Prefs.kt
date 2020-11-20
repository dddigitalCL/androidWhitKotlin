package com.everis.appires

import android.content.Context
import android.content.SharedPreferences
import java.util.stream.Collectors.toSet

class Prefs (context: Context){
    val PREFS_NAME = "preferences"
    val SHARED_NAME = "shared_name"
    val SHARED_PASS = "shared_pass"
    val SHAREDUSUARIO = "shared_usuario"
    val SHAREDNOMBRE = "shared_nombre"
    val SHAREDCORREO= "shared_correo"
    val SHAREDPASSWORD= "shared_password"
    val SHARED_FORGET = "shared_forget"


    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)

    var name:String?
        get() = prefs.getString(SHARED_NAME, "")
        set(value) = prefs.edit().putString(SHARED_NAME,value).apply()

    var password: String ?
        get() = prefs.getString(SHARED_PASS, "")
        set(value) = prefs.edit().putString(SHARED_PASS, value).apply()

    var datosUsuario:String?
        get() = prefs.getString(SHAREDUSUARIO, "")
        set(value) = prefs.edit().putString(SHAREDUSUARIO,value).apply()

    var datosNombre:String?
        get() = prefs.getString(SHAREDNOMBRE, "")
        set(value) = prefs.edit().putString(SHAREDNOMBRE, value).apply()

    var datosCorreo:String?
        get() = prefs.getString(SHAREDCORREO, "")
        set(value) = prefs.edit().putString(SHAREDCORREO, value).apply()

    var datosPassword:String?
        get() = prefs.getString(SHAREDPASSWORD, "")
        set(value) = prefs.edit().putString(SHAREDPASSWORD, value).apply()

    var forget: Boolean
        get() = prefs.getBoolean(SHARED_FORGET, false)
        set(value) = prefs.edit().putBoolean(SHARED_FORGET, value).apply()



}


