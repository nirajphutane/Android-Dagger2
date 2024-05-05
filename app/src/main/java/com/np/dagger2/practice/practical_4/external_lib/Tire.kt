package com.np.dagger2.practice.practical_4.external_lib

import com.np.dagger2.core.appLog

class Tire {

    fun setRadialTiers() = appLog("Radial Tire(${this.hashCode()}) set.")
}