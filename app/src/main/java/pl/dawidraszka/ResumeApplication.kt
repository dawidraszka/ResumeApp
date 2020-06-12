package pl.dawidraszka

import android.app.Application

class ResumeApplication : Application() {
    val appComponent: ApplicationComponent = DaggerApplicationComponent.create()
}