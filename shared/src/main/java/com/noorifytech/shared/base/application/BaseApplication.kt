package com.noorifytech.shared.base.application

import android.app.Application

abstract class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        appContext = this
    }

    companion object {
        lateinit var appContext: Application
    }
}