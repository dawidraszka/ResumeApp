package pl.dawidraszka.resumeapp.application

import android.app.Application

class ResumeApplication : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}