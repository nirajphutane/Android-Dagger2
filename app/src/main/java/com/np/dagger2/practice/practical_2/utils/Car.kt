package com.np.dagger2.practice.practical_2.utils

import com.np.dagger2.core.appLog
import javax.inject.Inject
import javax.inject.Named

class Car @Inject constructor(@Named("DieselEngine") private val engine: IEngine, chassis: Chassis, wheels: Wheels) {

    init {
        appLog("Car(${this.hashCode()}) created")
    }

    // Method Injection
    @Inject
    fun startByRemote(remote: Remote) {
        remote.start(this)
        engine.start()
    }

    fun drive() = appLog("Car(${this.hashCode()}) is running.")
}