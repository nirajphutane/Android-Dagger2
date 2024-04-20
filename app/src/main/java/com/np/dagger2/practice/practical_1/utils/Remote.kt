package com.np.dagger2.practice.practical_1.utils

import com.np.dagger2.core.appLog
import javax.inject.Inject

class Remote @Inject constructor() {

    fun start(car: Car) {
        appLog("Car ${car.hashCode()} is started by Remote(${this.hashCode()}).")
    }
}