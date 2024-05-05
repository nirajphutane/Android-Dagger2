package com.np.dagger2.practice.practical_3.utils

import com.np.dagger2.core.appLog
import javax.inject.Inject

interface IEngine {

    fun start()
}

// With @Inject
class PetrolEngine @Inject constructor() : IEngine  {

    override fun start() {
        appLog("PetrolEngine(${this.hashCode()}) is Started.")
    }
}

// Like 3th party library (without @Inject)
class DieselEngine : IEngine  {

    override fun start() {
        appLog("DieselEngine(${this.hashCode()}) is Started.")
    }
}