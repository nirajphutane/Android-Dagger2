package com.np.dagger2.practice.practical_2.utils

import com.np.dagger2.core.appLog
import javax.inject.Inject


interface IEngine {

    fun start()
}
class PetrolEngine @Inject constructor() : IEngine  {

    override fun start() {
        appLog("PetrolEngine(${this.hashCode()}) is Started.")
    }
}

class DieselEngine @Inject constructor() : IEngine  {

    override fun start() {
        appLog("DieselEngine(${this.hashCode()}) is Started.")
    }
}