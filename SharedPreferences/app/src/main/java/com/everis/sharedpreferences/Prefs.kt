package com.everis.sharedpreferences

import android.content.Context
import android.content.SharedPreferences

class Prefs (context: Context){
    val PREFS_NAME = "preferences"
    val SHARED_NAME = "shared_name"
    val SHARED_PASS = "shared_pass"
    val SHAREDNOMBRE = "shared_nombre"
    val SHAREDAPELLIDO = "shared_apellido"
    val SHAREDEDAD= "shared_edad"
    val SHAREDCIVIL= "shared_civil"
    val SHARED_FORGET = "shared_forget"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)

    var name:String?
    get() = prefs.getString(SHARED_NAME, "")
    set(value) = prefs.edit().putString(SHARED_NAME,value).apply()

    var password: String ?
        get() = prefs.getString(SHARED_PASS, "")
        set(value) = prefs.edit().putString(SHARED_PASS, value).apply()

    var datosNombre:String?
        get() = prefs.getString(SHAREDNOMBRE, "")
        set(value) = prefs.edit().putString(SHAREDNOMBRE,value).apply()

    var datosApellido:String?
        get() = prefs.getString(SHAREDAPELLIDO, "")
        set(value) = prefs.edit().putString(SHAREDAPELLIDO, value).apply()

    var datosEdad:String?
        get() = prefs.getString(SHAREDEDAD, "")
        set(value) = prefs.edit().putString(SHAREDEDAD, value).apply()

    var datosCivil:String?
        get() = prefs.getString(SHAREDCIVIL, "")
        set(value) = prefs.edit().putString(SHAREDCIVIL, value).apply()

    var forget: Boolean
        get() = prefs.getBoolean(SHARED_FORGET, false)
        set(value) = prefs.edit().putBoolean(SHARED_FORGET, value).apply()
}