package com.example.apptareas

import android.app.Application
import android.os.Bundle

class TaskApplication:Application() {

    companion object{
        lateinit var prefs:Preferences
    }

    override fun onCreate() {
        super.onCreate()
        prefs = Preferences(baseContext)
    }
}