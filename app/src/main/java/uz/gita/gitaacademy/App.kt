package uz.gita.gitaacademy

import android.app.Application

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        application = this
    }

    companion object {
        lateinit var application: Application
    }


}