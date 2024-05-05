package com.np.dagger2.practice.practical_6

import android.app.Application
import com.np.dagger2.practice.practical_6.di.ApplicationComponent
import com.np.dagger2.practice.practical_6.di.DaggerApplicationComponent

class Dagger2Application: Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.create()
    }
}