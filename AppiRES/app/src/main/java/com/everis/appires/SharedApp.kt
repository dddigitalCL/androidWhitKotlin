package com.everis.appires

import android.app.Application

class SharedApp:Application() {

    companion object {
        //CREA LA INSTANCIA DE UNA CLASE PARA HACERLA GLOBAL, GRACIAS AL "COMPANION OBJECT"
        //EN ESTE CASO ES PARA TENER ACCESO A LOS GET Y SET DEL SHARED PREFERENCE
        lateinit var prefs: Prefs
    }

    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
    }
}