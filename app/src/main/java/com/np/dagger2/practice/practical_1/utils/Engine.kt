package com.np.dagger2.practice.practical_1.utils

import com.np.dagger2.core.appLog
import javax.inject.Inject

class Engine @Inject constructor() {

    fun start() {
        appLog("Engin(${this.hashCode()}) is Started.")
    }
}
