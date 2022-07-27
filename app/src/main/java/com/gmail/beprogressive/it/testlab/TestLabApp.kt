package com.gmail.beprogressive.it.testlab

import android.app.Application
import timber.log.Timber

class TestLabApp: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}