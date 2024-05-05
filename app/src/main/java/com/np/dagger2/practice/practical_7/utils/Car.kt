package com.np.dagger2.practice.practical_7.utils

import com.np.dagger2.core.appLog
import com.np.dagger2.practice.practical_7.external_lib.Company
import javax.inject.Inject

class Car @Inject constructor(
    private val engine: IEngine,
    chassis: Chassis,
    wheels: Wheels,
    company: Company
) {

    init {
        appLog("Car(${this.hashCode()}) created by Company(${company.hashCode()})")
    }

    // Method Injection
    @Inject
    fun startByRemote(remote: Remote) {
        remote.start(this)
        engine.start()
    }

    fun drive() = appLog("Car(${this.hashCode()}) is running.")
}